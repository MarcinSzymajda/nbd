package org.example.entity;

import java.time.LocalDateTime;

public class Rent {

    private int id;
    private Court court;
    private Client client;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Rent(int id,
                Court court,
                Client client,
                LocalDateTime startTime) {
        this.id = id;
        this.court = court;
        this.client = client;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
