package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Rent;

public class RentRepository implements Repository<Rent>{


    @Override
    public boolean add(Rent obj) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager em = emf.createEntityManager()) {
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
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Rent rent = em.find(Rent.class, id);
            em.remove(rent);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Rent find(Rent obj) {
        Rent rent;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            rent = em.find(Rent.class, obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        }
        return rent;
    }
}
