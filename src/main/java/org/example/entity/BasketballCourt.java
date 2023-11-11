package org.example.entity;

public class BasketballCourt extends Court {

    private double basketHeight;
    private double basketRadius;

    public BasketballCourt(int id,
                           double width,
                           double length,
                           double basketHeight,
                           double basketRadius) {
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
