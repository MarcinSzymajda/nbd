package org.example.repository;

import org.example.entity.Court;

import java.util.List;

public class CourtRepository implements Repository<Court> {


    @Override
    public boolean add(Court obj) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Court find(int id) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(Court court) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Court> findAll() {
        try{
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() throws IllegalStateException {
    }
}
