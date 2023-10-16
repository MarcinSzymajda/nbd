package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Rent;

import java.util.List;

public class RentRepository implements IRentRepository{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Rent obj) {
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
            Rent rent = em.find(Rent.class, id);
            em.remove(rent);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RollbackException(e);
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
            throw new EntityNotFoundException(e);
        }
        return rent;
    }

    @Override
    public List<Rent> findAll() {
        List<Rent> rents;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select r from Rent r");
            rents = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return rents;
    }

    public List<Rent> findByCourtId(int id) {
        List<Rent> rents;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select r from Rent r where r.court.id = :id");
            query.setParameter("id", id);
            rents = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return rents;
    }

    public List<Rent> findByClientId(int id) {
        List<Rent> rents;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select r from Rent r where r.client.id = :id");
            query.setParameter("id", id);
            rents = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return rents;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
