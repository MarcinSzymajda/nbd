package org.example.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.entity.SimpleClass;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.example.entity.Rent;
import java.util.Properties;

public class Producer {


        public static KafkaProducer<String, String> producer;

        public static void initProducer() {
            Properties producerConfig = new Properties();

            producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

            producerConfig.put(ProducerConfig.CLIENT_ID_CONFIG, "local");
            producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9190,kafka2:9191,kafka3:9192");
            producerConfig.put(ProducerConfig.ACKS_CONFIG, "all");

            producer = new KafkaProducer<>(producerConfig);
        }

    public static void sendRentToKafka(SimpleClass rent) {
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            String rentJson = objectMapper.writeValueAsString(rent);
            System.out.println(rentJson);
            ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", rentJson);

            producer.send(record);
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


