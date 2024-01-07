package org.example;


import org.example.entity.*;
import org.example.kafka.Producer;
import java.util.Calendar;
import java.util.Date;

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

        SimpleClass simpleClass = new SimpleClass(1, "super");

        Producer.initProducer();
        Producer.sendRentToKafka(simpleClass);


    }
}