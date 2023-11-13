package org.example.entity;

public class FootballCourt extends Court {

    private double goalWidth;
    private double goalLength;

    public FootballCourt(int id,
                         double width,
                         double length,
                         double goalWidth,
                         double goalLength) {
        super(id, width, length);
        this.goalWidth = goalWidth;
        this.goalLength = goalLength;
    }

    public FootballCourt(int id,
                         double width,
                         double length,
                         int isRented,
                         double goalWidth,
                         double goalLength) {
        super(id, width, length, isRented);
        this.goalWidth = goalWidth;
        this.goalLength = goalLength;
    }

    public double getGoalWidth() {
        return goalWidth;
    }

    public void setGoalWidth(double goalWidth) {
        this.goalWidth = goalWidth;
    }

    public double getGoalLength() {
        return goalLength;
    }

    public void setGoalLength(double goalLength) {
        this.goalLength = goalLength;
    }
}
