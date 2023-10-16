import jakarta.persistence.*;
import org.example.entity.*;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDateTime;



public class MainTest {
    Client c1 = new Client("Marcin","Szymajda","123");
    Client c2 = new Client("Jakub","Osypiuk","456");
    Client c3 = new Client("Dominik","Marzec","123567");

    Court co1 = new FootballCourt(25.5,12.3,3.25,2.25);
    Court co2 = new BasketballCourt(22.4,21.5,2.8,1.1);
    Court co3 = new VolleyballCourt(15.2,13.2,1.25,15.0);

    @Test
    public void rentRepoTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
        EntityManager firstTransaction = emf.createEntityManager();
        EntityManager secondTransaction = emf.createEntityManager();
        EntityManager em = emf.createEntityManager();

        firstTransaction.getTransaction().begin();
        secondTransaction.getTransaction().begin();

        CourtRepository courtr = new CourtRepository();
        Court court = courtr.find(1);


        Rent rent = new Rent(court,c1, LocalDateTime.now());
        Rent rent2 = new Rent(court,c2,LocalDateTime.now());

        em.persist(rent);
        em.persist(rent2);

        Assertions.assertDoesNotThrow(() -> firstTransaction.getTransaction().commit());

        RollbackException rbe = Assert.assertThrows(RollbackException.class,() -> secondTransaction.getTransaction().commit());
        Assert.assertEquals(rbe.getCause(),OptimisticLockException.class);


    }
    @Test
    public void courtRepoTest() {
        try (CourtRepository CourtRepo = new CourtRepository()) {
            Assert.assertTrue(CourtRepo.add(co1));
            Assert.assertTrue(CourtRepo.add(co2));
            Assert.assertTrue(CourtRepo.add(co3));

            Assert.assertEquals(CourtRepo.find(2),co2);

            Assert.assertEquals(CourtRepo.findAll().size(),3);

            Assert.assertTrue(CourtRepo.remove(2));

            Assert.assertEquals(CourtRepo.findAll().size(),2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void clientRepoTest() {
        try (ClientRepository ClientRepo = new ClientRepository()) {
            Assert.assertTrue(ClientRepo.add(c1));
            Assert.assertTrue(ClientRepo.add(c2));
            Assert.assertTrue(ClientRepo.add(c3));

            Assert.assertEquals(ClientRepo.find(2),c2);

            Assert.assertEquals(ClientRepo.findAll().size(),3);

            Assert.assertTrue(ClientRepo.remove(2));

            Assert.assertEquals(ClientRepo.findAll().size(),2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
