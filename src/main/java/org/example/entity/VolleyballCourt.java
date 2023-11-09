package org.example.entity;


import org.bson.codecs.pojo.annotations.BsonProperty;

public class VolleyballCourt extends Court {

    @BsonProperty("netLength")
    private double netLength;
    @BsonProperty("netLength")
    private double netWidth;

    public VolleyballCourt(@BsonProperty("_id") int id,
                           @BsonProperty("width") double width,
                           @BsonProperty("length")  double length,
                           @BsonProperty("netLength")  double netLength,
                           @BsonProperty("netLength")  double netWidth) {
        super(id, width, length);
        this.netLength = netLength;
        this.netWidth = netWidth;
    }

    public double getNetLength() {
        return netLength;
    }

    public void setNetLength(double netLength) {
        this.netLength = netLength;
    }

    public double getNetWidth() {
        return netWidth;
    }

    public void setNetWidth(double netWidth) {
        this.netWidth = netWidth;
    }
}
