package org.example.entity;

public abstract class Court {

    private int id;
    private double width;
    private double length;
    private int version;
    private boolean isRented;

    public Court(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Court() {
    }

    public int getId() {
        return id;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
}
