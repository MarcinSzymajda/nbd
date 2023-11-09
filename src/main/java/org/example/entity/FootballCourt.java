package org.example.entity;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class FootballCourt extends Court {

    @BsonProperty("goalWidth")
    private double goalWidth;
    @BsonProperty("goalLength")
    private double goalLength;

    @BsonCreator
    public FootballCourt(@BsonProperty("_id") int id,
                         @BsonProperty("width") double width,
                         @BsonProperty("length")  double length,
                         @BsonProperty("goalWidth")  double goalWidth,
                         @BsonProperty("goalLength")  double goalLength) {
        super(id, width, length);
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
