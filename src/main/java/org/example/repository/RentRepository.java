package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Rent;

public class RentRepository implements Repository<Rent>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Rent obj) {
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
            Rent rent = em.find(Rent.class, id);
            em.remove(rent);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Rent find(int id) {
        Rent rent;
        try  {
            em.getTransaction().begin();
            rent = em.find(Rent.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        }
        return rent;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
