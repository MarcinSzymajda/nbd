package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;
import org.example.entity.Rent;

public class RentRepository implements Repository<Rent>{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Rent obj) {
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
            Client client = em.find(Client.class, id);
            em.remove(client);
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
    public Rent find(Rent obj) {
        Rent rent;
        try {
            em.getTransaction().begin();
            rent = em.find(Rent.class, obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            emf.close();
        }
        return rent;
    }
}
