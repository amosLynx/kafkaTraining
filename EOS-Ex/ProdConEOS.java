package com.ex;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProdConEOS {
    private static final Logger log = LoggerFactory.getLogger(ProdConEOS.class);

    public static void main(String[] args) {
        final String bootstrapServers = "localhost:9092";
        final String sinkTopic = "sink-topic";
        final String groupId = "test-CG";
        final String consumerTopic = "purchases";

        // create Producer properties
        Properties producerProps = new Properties();
        producerProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.ACKS_CONFIG, "all"); // Force broker to ackownlegde only after all ISRs
                                                                      // confirmed
        producerProps.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true"); // enable idempotence

        // create consumer configs
        Properties consumerProps = new Properties();
        consumerProps.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProps.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        consumerProps.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerProps.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"); // Disable auto commits so we can
                                                                                      // do it manually

        // create the producer
        final KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);

        // create consumer
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);

        // get a reference to the current thread
        final Thread mainThread = Thread.currentThread();

        // adding the shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Detected a shutdown, let's exit by calling consumer.wakeup()...");
                consumer.wakeup();
                // join the main thread to allow the execution of the code in the main thread
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {

            // subscribe consumer to our topic(s)
            consumer.subscribe(Arrays.asList(consumerTopic));

            // poll for new data
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : records) {
                    // create a producer record
                    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(sinkTopic, record.key(),
                            record.value());
                    // commit the consumer record and send to new topic
                    commitAndProcess(producer, consumer, record, producerRecord);

                    // log.info("Key: " + record.key() + ", Value: " + record.value());
                    // log.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                }
            }

        } catch (Exception e) {
            log.error("Unexpected exception", e);
        } finally {
            // flush data - synchronous
            producer.flush();
            // flush and close producer
            producer.close();

            consumer.close();
            log.info("The consumer is now gracefully closed.");
        }
    }

    private static void commitAndProcess(KafkaProducer<String, String> producer,
            final KafkaConsumer<String, String> consumer, ConsumerRecord<String, String> record,
            ProducerRecord<String, String> producerRecord) {

        boolean sendSuccess = false;

        int retrylimit = 5; //try and resend a message max 5 times

        RecordMetadata metadata = new RecordMetadata(null, 0, 0, 0, 0, 0);

        TopicPartition partition = new TopicPartition(record.topic(), record.partition()); // Get record topic and its
                                                                                           // partition

        OffsetAndMetadata offset = new OffsetAndMetadata(record.offset() + 1); // indicate that you have successfully
                                                                               // processed up to the next offset after
                                                                               // the current record
        Map<TopicPartition, OffsetAndMetadata> offsetMap = Collections.singletonMap(partition, offset);

        while (!sendSuccess) {
            if (retrylimit != 0) {
                try {
                    metadata = producer.send(producerRecord).get(); // block
                    sendSuccess = true;
                } catch (InterruptedException | ExecutionException e) {
                    retrylimit--;
                    log.info(e.getMessage());
                    log.info("Producing message with offeset "+metadata.offset()+" to topic "+metadata.topic()+" failed. "+retrylimit+" retries left ");
                }
            }else{
                log.info("retry limit past! on offset: "+metadata.offset()+ "timestamp: "+metadata.timestamp());
                break;
            }
         
        }

        consumer.commitSync(offsetMap);

    }
}
