package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;

public class CilentRepository implements Repository<Client> {

    @Override
    public boolean add(Client obj) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager em = emf.createEntityManager())  {
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
            Client client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Client find(Client obj) {
        Client client;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            client = em.find(Client.class, obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        }
        return client;
    }
}
