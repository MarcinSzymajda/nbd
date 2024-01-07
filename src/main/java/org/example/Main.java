package org.example;

import org.example.entityKafka.RentKfk;
import org.example.kafka.Producer;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        RentKfk rent = new RentKfk(9, "Lodz_rental", 99,999, new Date(), null);

        Producer producer = new Producer();

        producer.initProducer();
        producer.sendRentToKafka(rent);
    }
}