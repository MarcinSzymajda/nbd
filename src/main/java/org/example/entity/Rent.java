package org.example.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentID;
    private Date beginTime;
    private Date endTime;
    @ManyToOne
    @JoinColumn
    private Court court;
    @ManyToOne
    @JoinColumn
    private Client client;

    public Rent(Date beginTime, Date endTime, Court court, Client client) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.court = court;
        this.client = client;
    }

    public Rent() {
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getRentID() {
        return rentID;
    }

    public Court getCourt() {
        return court;
    }

    public Client getClient() {
        return client;
    }
}
