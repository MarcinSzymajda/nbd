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
    public void rentLockTest() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
             EntityManager firstManager = emf.createEntityManager();
             EntityManager secondManager = emf.createEntityManager()) {

            firstManager.getTransaction().begin();
                 firstManager.persist(co1);
                 firstManager.persist(c1);
            firstManager.getTransaction().commit();

            firstManager.getTransaction().begin();
            secondManager.getTransaction().begin();

                Court court1 = firstManager.find(Court.class, 1);
                court1.setRented(true);

                Court court2 = secondManager.find(Court.class, 1);
                court2.setRented(true);

                Rent rent1 = new Rent(court1, c1, LocalDateTime.now());
                Rent rent2 = new Rent(court2, c1, LocalDateTime.now());

                firstManager.persist(rent1);
                secondManager.persist(rent2);

            Assertions.assertDoesNotThrow(() -> firstManager.getTransaction().commit());
            RollbackException rbe = Assert.assertThrows(RollbackException.class, () -> secondManager.getTransaction().commit());
            Assert.assertTrue(rbe.getCause() instanceof OptimisticLockException);
        }
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
        }
    }
}
