package org.example.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)
public abstract class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double width;
    private double length;

    @Version
    private int version;

    public Court() {};

    public Court(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public int getId() {
        return id;
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
}
