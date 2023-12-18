package org.example.repository;


import com.datastax.oss.driver.api.core.CqlIdentifier;
import org.example.dao.RentDao;
import org.example.entity.Rent;
import org.example.mapper.RentMapper;
import org.example.mapper.RentMapperBuilder;

public class RentManager extends AbstractCassandraRepository implements Repository<Rent>{

    private RentDao rentDao;
    public RentManager() {
        super();
        RentMapper rentMapper = new RentMapperBuilder(super.getSession()).build();
        rentDao = rentMapper.rentDao(CqlIdentifier.fromCql("rent_a_court"), "rents");
    }

    public boolean add(Rent rent) {
        try {
            rentDao.save(rent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(int id) {
        try {
            rentDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean end(Rent rent) {
        try {
            rentDao.end(rent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Rent find(int id) {
        try {
            return rentDao.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Rent rent) {
        try {
            rentDao.save(rent);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
