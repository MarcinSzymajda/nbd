package org.example.entity;


import java.time.LocalDateTime;

public class Rent {

    private int id;
    private Court court;
    private Client client;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Rent(Court court, Client client, LocalDateTime startTime) {
        this.court = court;
        this.client = client;
        this.startTime = startTime;
    }

    public Rent() {
    }

    public int getId() {
        return id;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Court getCourt() {
        return court;
    }

    public Client getClient() {
        return client;
    }
}
