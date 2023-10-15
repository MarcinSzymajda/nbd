package org.example.entity;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("volleyball")
public class VolleyballCourt extends Court {

    private double netLength;
    private double netWidth;


    public VolleyballCourt(double width, double length, boolean isRented, double netLength, double netWidth) {
        super(width, length, isRented);
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
