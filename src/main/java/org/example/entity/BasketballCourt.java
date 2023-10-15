package org.example.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("basketball")
@Access(AccessType.FIELD)
public class BasketballCourt extends Court {

    private double basketHeight;
    private double basketRadius;

    public BasketballCourt(double width, double length, boolean isRented, double basketHeight, double basketRadius) {
        super(width, length, isRented);
        this.basketHeight = basketHeight;
        this.basketRadius = basketRadius;
    }

    public BasketballCourt() {
    }

    public double getBasketHeight() {
        return basketHeight;
    }

    public double getBasketRadius() {
        return basketRadius;
    }
}
