package org.example;

public class FootballCourt extends Court {

    private double goalWidth;
    private double goalLength;

    private int courtId;

    public FootballCourt(double width, double length,double goalLength,double goalWidth,int courtId) {
        super(width, length);
        this.goalLength = goalLength;
        this.goalWidth = goalWidth;
        this.courtId = courtId;
    }

    public int getCourtId() {
        return courtId;
    }

    public double getGoalWidth() {
        return goalWidth;
    }

    public double getGoalLength() {
        return goalLength;
    }
}
