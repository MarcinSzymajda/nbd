package org.example.entity;


import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;

public class Rent extends AbstractEntityMgd {

    @BsonProperty("court")
    private Court court;
    @BsonProperty("client")
    private Client client;
    @BsonProperty("startTime")
    private LocalDateTime startTime;
    @BsonProperty("endTime")
    private LocalDateTime endTime;

    @BsonCreator
    public Rent(@BsonProperty("_id") int id,
                @BsonProperty("court") Court court,
                @BsonProperty("client") Client client,
                @BsonProperty("startTime") LocalDateTime startTime) {
        super(id);
        this.court = court;
        this.client = client;
        this.startTime = startTime;
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
