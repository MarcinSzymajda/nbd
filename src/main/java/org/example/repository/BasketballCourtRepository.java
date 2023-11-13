package org.example.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.example.entityMgd.BasketballCourtMgd;

import static com.mongodb.client.model.Filters.eq;

public class BasketballCourtRepository extends AbstractMongoRepository implements Repository<BasketballCourtMgd>  {

    private final MongoCollection<BasketballCourtMgd> courts = getDatabase().getCollection("courts", BasketballCourtMgd.class);
    @Override
    public boolean add(BasketballCourtMgd obj) {
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
    public BasketballCourtMgd find(int id) {
        try {
            return courts.find(eq("_id", id)).first();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(BasketballCourtMgd obj) {
        try {
            courts.replaceOne(eq("_id", obj.getId()), obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FindIterable<BasketballCourtMgd> findAll() {
        try {
            return courts.find();
        } catch (Exception e) {
            return null;
        }
    }
}
