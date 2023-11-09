package org.example.entity;


import org.bson.codecs.pojo.annotations.BsonProperty;

public class VolleyballCourt extends Court {

    @BsonProperty("netLength")
    private double netLength;
    private double netWidth;

    public VolleyballCourt(double width, double length, double netLength, double netWidth) {
        super(width, length);
        this.netLength = netLength;
        this.netWidth = netWidth;
    }

    public VolleyballCourt() {
    }

    public double getNetLength() {
        return netLength;
    }

    public double getNetWidth() {
        return netWidth;
    }
}
