import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.*;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class MainTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private ClientRepository ClientRepo = new ClientRepository();
    private CourtRepository CourtRepo = new CourtRepository();
    private RentRepository RentRepo = new RentRepository();

    Client c1 = new Client("Marcin","Szymajda","123");
    Client c2 = new Client("Jakub","Osypiuk","456");
    Client c3 = new Client("Dominik","Marzec","123567");

    Court co1 = new FootballCourt(25.5,12.3,3.25,2.25);
    Court co2 = new BasketballCourt(22.4,21.5,2.8,1.1);
    Court co3 = new VolleyballCourt(15.2,13.2,1.25,15.0);

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("myapp");
        em = emf.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        if(emf!=null) {
            emf.close();
        }
    }

    @Test
    public void rentRepoTest() {

    }
    @Test
    public void courtRepoTest() {


        Assert.assertTrue(CourtRepo.add(co1));
        Assert.assertTrue(CourtRepo.add(co2));
        Assert.assertTrue(CourtRepo.add(co3));

        Assert.assertEquals(CourtRepo.find(2),co2);

        Assert.assertEquals(CourtRepo.findAll().size(),3);

        Assert.assertTrue(CourtRepo.remove(2));

        Assert.assertEquals(CourtRepo.findAll().size(),2);

    }

    @Test
    public void clientRepoTest() {


    Assert.assertTrue(ClientRepo.add(c1));
    Assert.assertTrue(ClientRepo.add(c2));
    Assert.assertTrue(ClientRepo.add(c3));

    Assert.assertEquals(ClientRepo.find(2),c2);

    Assert.assertEquals(ClientRepo.findAll().size(),3);

    Assert.assertTrue(ClientRepo.remove(2));

    Assert.assertEquals(ClientRepo.findAll().size(),2);


    }


}
