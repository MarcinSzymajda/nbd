import org.example.entity.BasketballCourt;
import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.entity.VolleyballCourt;
import org.example.mapper.CourtMapper;
import org.example.repository.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedisTest {

    RedisCourtRepository repository = new RedisCourtRepository();

    FootballCourt footballCourt = new FootballCourt(1,1,1,1,1,1);
    Court basketCourt = new BasketballCourt(2,1,1,1,1,1);
    Court volleyballCourt = new VolleyballCourt(3,1,1,1,1,1);

    FootballCourt footballTestCourt = new FootballCourt(11,1,1,1,1,1);

    @Test
    public void addTest() {

        assertTrue(repository.addJson(footballCourt));
        assertTrue(repository.addJson(basketCourt));
        assertTrue(repository.addJson(volleyballCourt));

        Court fcourt = repository.findJson(footballCourt.getId());
        assertEquals(fcourt,footballCourt);

        Court bcourt = repository.findJson(basketCourt.getId());
        assertEquals(basketCourt,bcourt);

        Court vcourt = repository.findJson(volleyballCourt.getId());
        assertEquals(vcourt,volleyballCourt);

    }

    @Before
    public void setUp() {
        try(AbstractMongoRepository repo = new ClientRepository()) {
            repo.getDatabase().drop();
        }
    }

    @Test
    public void wrapperTest() {
        try(RedisMongoWrapper wrapper = new RedisMongoWrapper(); CourtRepository cr = new CourtRepository()) {
            cr.add(CourtMapper.toMongoCourt(footballCourt)); // Dodajemy boisko do MongoDB
            //repository.addJson(footballCourt); // Dodajemy boisko do Redisa
            assertNotNull(wrapper.findJson(footballCourt.getId())); // W przypadku ubicia Redisa dokument zaczytamy z Mongo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void redisEfficientyTest() {
        repository.addJson(footballTestCourt);

        for(int i=0;i<200;i++) {
            Court newCourt = repository.findJson(11);
        }
    }

    @Test
    public void mongoEfficientyTest() {

        try(CourtRepository courtRepository = new CourtRepository()) {
            courtRepository.add(CourtMapper.toMongoCourt(footballTestCourt));

            for(int i=0;i<200;i++) {
                Court newCourt = CourtMapper.fromMongoCourt(courtRepository.find(11));
            }

        } catch (Exception e) {

        }
    }
    @Test
    public void flushTest() {
        assertTrue(repository.deleteAllJson());
        assertNull(repository.findJson(footballCourt.getId()));
        assertNull(repository.findJson(basketCourt.getId()));
        assertNull(repository.findJson(volleyballCourt.getId()));
    }
}
