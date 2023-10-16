package org.example.manager;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.RollbackException;
import org.example.repository.Repository;

import java.util.List;

public abstract class Manager<T> implements AutoCloseable {

    private final Repository<T> repository;

    public Manager(Repository<T> repository) {
        this.repository = repository;
    }

    public boolean add(T obj) {
        try {
            return repository.add(obj);
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean removeCourt(int id) {
        try {
            return repository.remove(id);
        } catch (RollbackException e) {
            return false;
        }
    }

    public T find(int id) {
        try {
            return repository.find(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public List<T> findAll() {
        try {
            return repository.findAll();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        repository.close();
    }
}
