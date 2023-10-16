package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Court;
import org.example.entity.Rent;

import java.time.LocalDateTime;
import java.util.List;

public class RentRepository implements Repository<Rent>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Rent obj) {
        try {
            em.getTransaction().begin();
            Court court = em.find(Court.class, obj.getCourt().getId());

            if (court.isRented()) {
                em.getTransaction().rollback();
                return false;
            } else {
                court.setRented(true);
                em.persist(obj);
                em.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public boolean leave(int id) {
        try {
            em.getTransaction().begin();
            Rent rent = em.find(Rent.class, id);
            rent.getCourt().setRented(false);
            rent.setEndTime(LocalDateTime.now());
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            em.getTransaction().begin();
            Rent rent = em.find(Rent.class, id);
            em.remove(rent);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Rent find(int id) {
        try {
            em.getTransaction().begin();
            Rent rent = em.find(Rent.class, id);
            em.getTransaction().commit();
            return rent;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Rent> findAll() {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select r from Rent r");
            List<Rent> rents = query.getResultList();
            em.getTransaction().commit();
            return rents;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() throws IllegalStateException {
        emf.close();
        em.close();
    }
}
