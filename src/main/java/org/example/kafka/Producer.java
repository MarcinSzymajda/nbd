package org.example.kafka;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Properties;

public class Producer {

    public static KafkaProducer<String, String> producer;

    public static KafkaProducer<String, String> initProducer() {
        Properties producerConfig = new Properties();
//        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        properties.setProperty("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //producerConfig.put("value.serializer", JsonSerializer.class.getName());

        producerConfig.put(ProducerConfig.CLIENT_ID_CONFIG, "local");
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9190,kafka2:9191,kafka3:9192");
        producerConfig.put(ProducerConfig.ACKS_CONFIG, "all");

        return new KafkaProducer<>(producerConfig);
    }

}
