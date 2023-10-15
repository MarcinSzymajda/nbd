import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class MainTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

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
    public void testConn() {

        //public Client(String firstName, String lastName, String personalID, int clientID) {
//    Client client = new Client("Marcin","Szymajda","123",1);
//    em.getTransaction().begin();
//    em.persist(client);
//    em.getTransaction().commit();
    }

    @Test
    public void basicAssert() {

        Assert.assertEquals("Hello","Hello");
    }

    @Test
    public void testDB() {


    }
}
