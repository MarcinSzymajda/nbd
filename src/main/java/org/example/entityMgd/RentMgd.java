package org.example.entityMgd;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.time.LocalDateTime;

public class RentMgd {

    @BsonProperty("_id")
    private int id;
    @BsonProperty("court")
    private CourtMgd court;
    @BsonProperty("client")
    private ClientMgd client;
    @BsonProperty("start_time")
    private LocalDateTime startTime;
    @BsonProperty("end_time")
    private LocalDateTime endTime;

    @BsonCreator
    public RentMgd(
            @BsonProperty("court") CourtMgd court,
            @BsonProperty("client") ClientMgd client,
            @BsonProperty("start_time") LocalDateTime startTime) {
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

    public CourtMgd getCourt() {
        return court;
    }

    public void setCourt(CourtMgd court) {
        this.court = court;
    }

    public ClientMgd getClient() {
        return client;
    }

    public void setClient(ClientMgd client) {
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
