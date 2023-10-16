package org.example.repository;

import org.example.entity.Rent;

import java.util.List;

public interface IRentRepository extends Repository<Rent>{

    List<Rent> findByClientId(int id);
    List<Rent> findByCourtId(int id);
}
