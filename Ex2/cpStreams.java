package org.apache.kafka;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class cpStreams {
    final static Random random = new Random();

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        final String sourceTopic = "users";
        final String sinkTopic = "newUsers";

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // Create stream and read from source topic
        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> inputStream = builder.stream(sourceTopic);

        // call add age function for each record recieved
        KStream<String, String> outputStream = inputStream.mapValues(value -> addAge(value));
  
        // send modified record to sink topic
        outputStream.to(sinkTopic);

        // build topology
        final Topology topology = builder.build();
        System.out.println(topology.describe());
        final KafkaStreams streams = new KafkaStreams(topology, props);

        // shutdown handler
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
                System.out.println("Stopped");
            }
        });

        // Start the stream and attach the shutdown hook
        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);

    }

    public static String addAge(String value) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(value, HashMap.class);

            jsonMap.put("Age", random.nextInt((80 - 10) + 1) + 10);

            return objectMapper.writeValueAsString(jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
            return value;
        }
    }
}
