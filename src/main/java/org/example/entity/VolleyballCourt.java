package org.example.entity;

public class VolleyballCourt extends Court {

    private double netLength;
    private double netWidth;

    public VolleyballCourt(int id,
                           double width,
                           double length,
                           double netLength,
                           double netWidth) {
        super(id, width, length);
        this.netLength = netLength;
        this.netWidth = netWidth;
    }

    public VolleyballCourt(int id,
                           double width,
                           double length,
                           int isRented,
                           double netLength,
                           double netWidth) {
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
