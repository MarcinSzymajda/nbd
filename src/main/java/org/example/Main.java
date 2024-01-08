package org.example;

import org.example.entityKafka.RentKfk;
import org.example.kafka.Producer;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RentKfk rent = new RentKfk(2, "Lodz_rental", 99,999, new Date(), null);

        Producer producer = new Producer();

        producer.initProducer();
        producer.createTopic();
        producer.sendRentToKafka(rent);
    }
}