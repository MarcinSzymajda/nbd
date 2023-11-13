package org.example.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.example.entityMgd.VolleyballCourtMgd;

import static com.mongodb.client.model.Filters.eq;

public class VoleyballCourtRepository extends AbstractMongoRepository implements Repository<VolleyballCourtMgd> {

    private final MongoCollection<VolleyballCourtMgd> courts = getDatabase().getCollection("courts", VolleyballCourtMgd.class);


    @Override
    public boolean add(VolleyballCourtMgd obj) {
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
    public VolleyballCourtMgd find(int id) {
        try {
            return courts.find(eq("_id", id)).first();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(VolleyballCourtMgd obj) {
        try {
            courts.replaceOne(eq("_id", obj.getId()), obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FindIterable<VolleyballCourtMgd> findAll() {
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
