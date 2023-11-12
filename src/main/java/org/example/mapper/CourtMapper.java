package org.example.mapper;

import org.bson.Document;
import org.example.entityMgd.BasketballCourtMgd;
import org.example.entityMgd.FootballCourtMgd;
import org.example.entityMgd.VolleyballCourtMgd;

public class CourtMapper {
    
    private static final String ID = "_id";
    private static final String WIDTH = "width";
    private static final String LENGTH = "length";
    private static final String IS_RENTED = "is_rented";
    private static final String NET_LENGTH = "net_length";
    private static final String NET_WIDTH = "net_width";
    private static final String GOAL_WIDTH = "goal_width";
    private static final String GOAL_LENGTH = "goal_length";
    private static final String BASKET_HEIGTH = "basket_height";
    private static final String BASKET_RADIUS = "basket_radius";

    public static FootballCourtMgd fromMongoCourtToFootballCourtMgd(Document courtDocument) {
        return new FootballCourtMgd(
                courtDocument.get(ID, Integer.class),
                courtDocument.get(WIDTH, Double.class),
                courtDocument.get(LENGTH, Double.class),
                courtDocument.get(IS_RENTED, Integer.class),
                courtDocument.get(GOAL_WIDTH, Double.class),
                courtDocument.get(GOAL_LENGTH, Double.class)
        );
    }

    public static BasketballCourtMgd fromMongoCourtToBasketballCourtMgd(Document courtDocument) {
        return new BasketballCourtMgd(
                courtDocument.get(ID, Integer.class),
                courtDocument.get(WIDTH, Double.class),
                courtDocument.get(LENGTH, Double.class),
                courtDocument.get(BASKET_HEIGTH, Double.class),
                courtDocument.get(BASKET_RADIUS, Double.class)
        );
    }

    public static VolleyballCourtMgd fromMongoCourtToVolleyballCourtMgd(Document courtDocument) {
        return new VolleyballCourtMgd(
                courtDocument.get(ID, Integer.class),
                courtDocument.get(WIDTH, Double.class),
                courtDocument.get(LENGTH, Double.class),
                courtDocument.get(NET_LENGTH, Double.class),
                courtDocument.get(NET_WIDTH, Double.class)
        );
    }
}
