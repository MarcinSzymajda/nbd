package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;
import org.example.entity.Court;

public class CourtRepository implements Repository<Court> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Court obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
            emf.close();
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
        } finally {
            em.close();
            emf.close();
        }
        return true;
    }

    @Override
    public Court find(Court obj) {
        Court court;
        try {
            em.getTransaction().begin();
            court = em.find(Court.class, obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
        return court;
    }
}
