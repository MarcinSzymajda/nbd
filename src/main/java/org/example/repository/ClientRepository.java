package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Client;

import java.util.List;

public class ClientRepository implements Repository<Client> {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Client obj) {
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
            Client client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RollbackException(e);
        }
        return true;
    }

    @Override
    public Client find(int id) {
        Client client;
        try {
            em.getTransaction().begin();
            client = em.find(Client.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Client c");
            clients = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
        return clients;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
