package com.ex.pbtojson;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.json.JSONObject;

import io.confluent.kafka.streams.serdes.protobuf.KafkaProtobufSerde;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;

public class Transformer {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        final String topic_Protobuf = "users";
        final String topic_Json = "topic_62";

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "Protobuf_to_Json_Pipe");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.ByteArray().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaProtobufSerde.class);
        props.put(CommonClientConfigs.GROUP_ID_CONFIG, "test-1");
        props.put("schema.registry.url", "http://localhost:8081");

        // Create stream and read from source topic
        final StreamsBuilder builder = new StreamsBuilder();

        Map<String, String> serdeConfig = new HashMap<>();
        serdeConfig.put("schema.registry.url", "http://localhost:8081");
        final KafkaJsonSchemaSerde<Users> jsonSerde = new KafkaJsonSchemaSerde<>();
        jsonSerde.configure(serdeConfig, false);

        serdeConfig.put("specific.protobuf.value.type",UserMessage.users.class.getName());
        final KafkaProtobufSerde<UserMessage.users> protobufSerde = new KafkaProtobufSerde<>();
        protobufSerde.configure(serdeConfig, false);



        KStream<byte[], UserMessage.users> protobufStream = builder.stream(topic_Protobuf,
                Consumed.with(Serdes.ByteArray(), protobufSerde));

        // Convert Protobuf to JSON
        protobufStream.mapValues((key,protobufData) -> {
            System.out.println("TEST");
            // Convert protobufData to JSON here using your preferred method
            System.out.println("key"+key+"region"+protobufData.getRegionid()+"registertime"+protobufData.getRegistertime()+"getGender"+protobufData.getGender());
            
            Users jsonUser = new Users();
            jsonUser.setRegistertime( protobufData.getRegistertime());
            jsonUser.setUserid( protobufData.getUserid());
            jsonUser.setRegionid(protobufData.getRegionid());
            jsonUser.setGender( protobufData.getGender());


           // System.out.println(jsonUser);
            return jsonUser;

        }).to(topic_Json, Produced.with(Serdes.ByteArray(),jsonSerde));

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

}
