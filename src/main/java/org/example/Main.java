package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.entity.*;
import org.example.kafka.Producer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {


        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        calendar.add(Calendar.DAY_OF_MONTH, 7);

        Date futureDate = calendar.getTime();

        Client client = new Client(1,"marcin","szymajda","123",0);

        FootballCourt footballCourt = new FootballCourt(456, 999, 999, 1, 999,43);

        Rent rent = new Rent(1,footballCourt,client,currentDate,futureDate);

        Producer.initProducer();
        Producer.sendRentToKafka(rent);


    }
}