package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Court;

import java.util.List;

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
            throw new PersistenceException(e);
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
            throw new RollbackException(e);
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
            throw new EntityNotFoundException(e);
        }
        return court;
    }

    @Override
    public List<Court> findAll() {
        List<Court> courts;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Court c");
            courts = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return courts;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
