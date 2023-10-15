package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;

public class CilentRepository implements Repository<Client> {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public boolean add(Client obj) {
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
            Client client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
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
            return null;
        }
        return client;
    }

    @Override
    public void close() throws Exception {
        emf.close();
        em.close();
    }
}
