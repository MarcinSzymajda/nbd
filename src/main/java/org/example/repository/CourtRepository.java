package org.example.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.entityMgd.CourtMgd;
import org.example.mapper.CourtMapper;

import static com.mongodb.client.model.Filters.eq;

public class CourtRepository extends AbstractMongoRepository implements Repository<CourtMgd> {

    private final MongoCollection<Document> courts = getDatabase().getCollection("courts");

//    @Override
//    public boolean add(CourtMgd court) {
//        try {
//            courts.insertOne(court);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean remove(int id) {
//        try {
//            courts.findOneAndDelete(eq("_id", id));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    @Override
    public boolean add(CourtMgd obj) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public CourtMgd find(int id) {
        try {
            return CourtMapper.fromMongoCourtToFootballCourtMgd(courts.find(eq("_id", id)).first());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(CourtMgd obj) {
        return false;
    }

    @Override
    public FindIterable<CourtMgd> findAll() {
        return null;
    }

//    @Override
//    public boolean update(CourtMgd court) {
//        try {
//            courts.replaceOne(eq("_id", court.getId()), court);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public FindIterable<CourtMgd> findAll() {
//        try{
//            return courts.find();
//        } catch (Exception e) {
//            return null;
//        }
//    }

    @Override
    public void close() {
        super.close();
    }
}
