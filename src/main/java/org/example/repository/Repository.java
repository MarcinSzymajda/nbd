package org.example.repository;

public interface Repository<T> {

    boolean add(T obj);
    boolean remove(int id);
    T find(T obj);

}
