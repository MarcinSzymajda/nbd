package org.example.repository;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.*;

import org.example.dao.ClientDao;
import org.example.dao.InventoryMapper;
import org.example.dao.InventoryMapperBuilder;
import org.example.entity.Client;

import java.util.List;

public class ClientRepository extends AbstractCassandraRepository {

    private ClientDao clientDao;

    public ClientRepository() {
        super();
        InventoryMapper inventoryMapper = new InventoryMapperBuilder(super.getSession()).build();
        clientDao = inventoryMapper.clientDao(CqlIdentifier.fromCql("clients"));
    }

    public boolean add(Client obj) {
        try {
            clientDao.save(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(int id) {
        try {
            clientDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Client find(int id) {
        try {
            return clientDao.findById(id);
        } catch (Exception e) {
            return null;
        }
    }
//
//    @Override
//    public boolean update(Client client) {
//        try {
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    @Override
//    public List<Client> findAll() {
//        try {
//
//            return null;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public void close() throws IllegalStateException {
//    }
}
