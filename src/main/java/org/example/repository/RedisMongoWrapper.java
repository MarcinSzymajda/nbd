package org.example.repository;

import org.example.entity.Court;
import org.example.mapper.CourtMapper;

public class RedisMongoWrapper extends AbstractMongoRepository {

    public RedisCourtRepository redisRepo = new RedisCourtRepository();
    public CourtRepository courtRepo = new CourtRepository();


//    public boolean add(CourtMgd court) {
//        try {
//            return redisRepo.addJson(CourtMapper.fromMongoCourt(court));
//        } catch (Exception e) {
//            return courtRepo.add(court);
//        }
//    }

    public Court findJson(int id) {
        try {
            return redisRepo.findJson(id);
        } catch (Exception e) {
            return CourtMapper.fromMongoCourt(courtRepo.find(id));
        }
    }
}
