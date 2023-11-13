package org.example.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.example.entityMgd.ClientMgd;
import org.example.entityMgd.FootballCourtMgd;

import static com.mongodb.client.model.Filters.eq;

public class FootballCourtRepository extends AbstractMongoRepository implements Repository<FootballCourtMgd>{

    private final MongoCollection<FootballCourtMgd> courts = getDatabase().getCollection("courts", FootballCourtMgd.class);


    @Override
    public boolean add(FootballCourtMgd obj) {
        try {
            courts.insertOne(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            courts.findOneAndDelete(eq("_id", id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FootballCourtMgd find(int id) {
        try {
            return courts.find(eq("_id", id)).first();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(FootballCourtMgd obj) {
        try {
            courts.replaceOne(eq("_id", obj.getId()), obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FindIterable<FootballCourtMgd> findAll() {
        try {
            return courts.find();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
