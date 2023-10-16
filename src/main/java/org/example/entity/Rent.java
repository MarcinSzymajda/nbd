package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn
    private Court court;
    @ManyToOne
    @JoinColumn
    private Client client;

    public Rent(LocalDateTime beginTime, LocalDateTime endTime, Court court, Client client) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.court = court;
        this.client = client;
    }

    public Rent() {
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getId() {
        return id;
    }

    public Court getCourt() {
        return court;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentID=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", court=" + court +
                ", client=" + client +
                '}';
    }
}
