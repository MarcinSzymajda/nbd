package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;
import org.example.entity.Court;

public class CourtRepository implements Repository<Court> {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Court obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        try {
            em.getTransaction().begin();
            Court court = em.find(Court.class, id);
            em.remove(court);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Court find(int id) {
        Court court;
        try {
            em.getTransaction().begin();
            court = em.find(Court.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        }
        return court;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
