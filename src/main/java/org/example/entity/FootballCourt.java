package org.example.entity;

public class FootballCourt extends Court {

    private double goalWidth;
    private double goalLength;


    public FootballCourt(double width, double length, double goalWidth, double goalLength) {
        super(width, length);
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
