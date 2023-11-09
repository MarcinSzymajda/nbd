package org.example.entity;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class BasketballCourt extends Court {

    @BsonProperty("basketHeight")
    private double basketHeight;
    @BsonProperty("basketRadius")
    private double basketRadius;

    @BsonCreator
    public BasketballCourt(@BsonProperty("_id") int id,
                           @BsonProperty("width") double width,
                           @BsonProperty("length") double length,
                           @BsonProperty("basketHeight") double basketHeight,
                           @BsonProperty("basketRadius") double basketRadius) {
        super(id, width, length);
        this.basketHeight = basketHeight;
        this.basketRadius = basketRadius;
    }

    public double getBasketHeight() {
        return basketHeight;
    }

    public void setBasketHeight(double basketHeight) {
        this.basketHeight = basketHeight;
    }

    public double getBasketRadius() {
        return basketRadius;
    }

    public void setBasketRadius(double basketRadius) {
        this.basketRadius = basketRadius;
    }
}
