package org.example.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)
public abstract class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courtID;
    private double width;
    private double length;

    private boolean isRented;

    public Court() {};

    public Court(double width, double length,boolean isRented) {
        this.width = width;
        this.length = length;
        this.isRented = isRented;

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
