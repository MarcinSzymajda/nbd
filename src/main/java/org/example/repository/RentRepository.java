package org.example.repository;


import org.example.entity.Rent;

import java.util.List;

public class RentRepository extends AbstractCassandraRepository{

    public RentRepository() {
        super();
    }

    //    @Override
//    public boolean add(Rent rent) {
//        try {
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean remove(int id) {
//        try {
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public Rent find(int id) {
//        try {
//
//            return null;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public boolean update(Rent rent) {
//        try {
//
//            return true;
//        } catch (Exception e) {
//
//            return false;
//        }
//    }
//
//    @Override
//    public List<Rent> findAll() {
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
//
//    }
}
