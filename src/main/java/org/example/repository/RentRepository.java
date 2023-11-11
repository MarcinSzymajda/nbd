package org.example.repository;

import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.example.entityMgd.ClientMgd;
import org.example.entityMgd.CourtMgd;
import org.example.entityMgd.RentMgd;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;

public class RentRepository extends AbstractMongoRepository implements Repository<RentMgd>{

    private final MongoCollection<RentMgd> rents = getDatabase().getCollection("rents", RentMgd.class);
    private final MongoCollection<ClientMgd> clients = getDatabase().getCollection("clients", ClientMgd.class);
    private final MongoCollection<CourtMgd> courts = getDatabase().getCollection("courts", CourtMgd.class);
    @Override
    public boolean add(RentMgd rent) {
        ClientSession clientSession = getMongoClient().startSession();
        try {
            clientSession.startTransaction();
            clients.updateOne(eq("_id", rent.getClient().getId()), inc("has_rent", 1));
            courts.updateOne(eq("_id", rent.getCourt().getId()), inc("is_rented", 1));
            rents.insertOne(rent);
            clientSession.commitTransaction();
            return true;
        } catch (Exception e) {
            clientSession.abortTransaction();
            return false;
        } finally {
            clientSession.close();
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            rents.findOneAndDelete(eq("_id", id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public RentMgd find(int id) {
        try {
            rents.find(eq("_id", id)).first();
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(RentMgd rent) {
        try {
            rents.replaceOne(eq("_id", rent.getId()), rent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FindIterable<RentMgd> findAll() {
        try {
            return rents.find();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
