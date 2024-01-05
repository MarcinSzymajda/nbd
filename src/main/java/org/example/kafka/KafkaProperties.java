package org.example.kafka;

import java.util.Properties;

public class KafkaProperties {

    public static Properties getConsumerProperties() {
        Properties properties = new Properties();

        // Replace "kafkanet" with the actual name of your Docker network
        properties.setProperty("bootstrap.servers", "kafka1:9190,kafka2:9191,kafka3:9192");
        properties.setProperty("group.id", "your-consumer-group");
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        return properties;
    }

}
