package org.example.entity;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import org.example.names.CourtIds;

@Entity(defaultKeyspace = "rent_a_court")
@CqlName("courts")
public class VolleyballCourt extends Court {

    @CqlName(CourtIds.NET_WIDTH)
    private double netWidth;
    @CqlName(CourtIds.NET_LENGTH)
    private double netLength;

    public VolleyballCourt(int id, double netLength, double netWidth, double width, double length, boolean rented, String discriminator) {
        super(id, width, length, rented, CourtIds.VOLLEYBALL);
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

    public void setNetWidth(double netWidth) {
        this.netWidth = netWidth;
    }

    public void setNetLength(double netLength) {
        this.netLength = netLength;
    }

    @Override
    public String toString() {
        return "VolleyballCourt{" +
                "id=" + super.getId() +
                ", width=" + super.getWidth() +
                ", length=" + super.getLength() +
                ", isRented=" + super.isRented() +
                ", discriminator='" + super.getDiscriminator() +
                ", netWidth=" + netWidth +
                ", netLength=" + netLength +
                '}';
    }
}
