package org.example.entity;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public abstract class Court extends AbstractEntityMgd {

    @BsonProperty("width")
    private double width;
    @BsonProperty("length")
    private double length;
    @BsonProperty("isRented")
    private boolean isRented;


    @BsonCreator
    public Court(@BsonProperty("_id") int id,
                 @BsonProperty("width") double width,
                 @BsonProperty("length") double length) {
        super(id);
        this.width = width;
        this.length = length;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
