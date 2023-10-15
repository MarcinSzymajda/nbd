package org.example.entity;

import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("football")
public class FootballCourt extends Court {

    private double goalWidth;
    private double goalLength;


    public FootballCourt(double width, double length, boolean isRented, double goalWidth, double goalLength) {
        super(width, length, isRented);
        this.goalWidth = goalWidth;
        this.goalLength = goalLength;
    }

    public FootballCourt() {
    }

    public double getGoalWidth() {
        return goalWidth;
    }

    public double getGoalLength() {
        return goalLength;
    }
}
