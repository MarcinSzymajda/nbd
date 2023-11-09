package org.example.repository;

import org.example.entity.Client;

import java.util.List;

public class ClientRepository implements Repository<Client> {



    @Override
    public boolean add(Client obj) {
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
    public Client find(int id) {
        try {

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean update(Client client) {
        try {

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Client> findAll() {
        try {

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() throws IllegalStateException {
    }
}
