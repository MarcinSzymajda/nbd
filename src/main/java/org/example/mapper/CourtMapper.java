package org.example.mapper;

import org.example.entity.BasketballCourt;
import org.example.entity.FootballCourt;
import org.example.entity.VolleyballCourt;
import org.example.entityMgd.BasketballCourtMgd;
import org.example.entityMgd.FootballCourtMgd;
import org.example.entityMgd.VolleyballCourtMgd;

public class CourtMapper {

    public static FootballCourt fromMongoCourtToFootballCourt(FootballCourtMgd footballCourt) {
        return new FootballCourt(
                footballCourt.getId(),
                footballCourt.getWidth(),
                footballCourt.getLength(),
                footballCourt.getIsRented(),
                footballCourt.getGoalLength(),
                footballCourt.getGoalWidth()
        );
    }

    public static BasketballCourt fromMongoCourtToBasketballCourt(BasketballCourtMgd basketballCourt) {
        return new BasketballCourt(
                basketballCourt.getId(),
                basketballCourt.getWidth(),
                basketballCourt.getLength(),
                basketballCourt.getIsRented(),
                basketballCourt.getBasketHeight(),
                basketballCourt.getBasketRadius()
        );
    }

    public static VolleyballCourt fromMongoCourtToVolleyballCourt(VolleyballCourtMgd volleyballCourt) {
        return new VolleyballCourt(
                volleyballCourt.getId(),
                volleyballCourt.getWidth(),
                volleyballCourt.getLength(),
                volleyballCourt.getIsRented(),
                volleyballCourt.getNetLength(),
                volleyballCourt.getWidth()
        );
    }

    public static BasketballCourtMgd toMongoBasketballCourt(BasketballCourt court) {
            return new BasketballCourtMgd(
                    court.getId(),
                    court.getWidth(),
                    court.getLength(),
                    court.getIsRented(),
                    court.getBasketHeight(),
                    court.getBasketRadius()
            );
    }

    public static FootballCourtMgd toMongoFootballCourt(FootballCourt court) {
        return new FootballCourtMgd(
                court.getId(),
                court.getWidth(),
                court.getLength(),
                court.getIsRented(),
                court.getGoalWidth(),
                court.getGoalLength()
        );
    }

    public static VolleyballCourtMgd toMongoVolleyballCourt(VolleyballCourt court) {
        return new VolleyballCourtMgd(
                court.getId(),
                court.getWidth(),
                court.getLength(),
                court.getIsRented(),
                court.getNetLength(),
                court.getNetWidth()
        );
    }
}
