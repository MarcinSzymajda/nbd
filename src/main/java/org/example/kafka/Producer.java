package org.example.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.entityKafka.RentKfk;

import java.util.Properties;

public class Producer {
    private KafkaProducer<String, String> producer;

    public void initProducer() {
        Properties producerConfig = new Properties();

        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        producerConfig.put(ProducerConfig.CLIENT_ID_CONFIG, "local");
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9192,kafka2:9292,kafka3:9392");
        producerConfig.put(ProducerConfig.ACKS_CONFIG, "all");

        producer = new KafkaProducer<>(producerConfig);
    }

    public void sendRentToKafka(RentKfk rentKfk) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String rentKfkJson = objectMapper.writeValueAsString(rentKfk);
            ProducerRecord<String, String> record = new ProducerRecord<>("test_part", rentKfkJson);

            producer.send(record);
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


