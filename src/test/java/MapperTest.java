import com.datastax.oss.driver.api.core.cql.Row;
import org.example.entity.*;
import org.example.mapper.CourtCustomMapper;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentManager;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MapperTest {

    Client c1 = new Client(1,false,"Marcin","Szymajda","123");
    Client c2 = new Client(2,false,"Jakub","Osypiuk","456");
    Client c3 = new Client(3,false,"Dominik","Marzec","123567");

    FootballCourt footballCourt = new FootballCourt(100,1.1,1.1,1,1,false, "");
    VolleyballCourt volleyballCourt = new VolleyballCourt(200,2.2,2.2,1,1,false, "");
    BasketballCourt basketballCourt = new BasketballCourt(300,3.3,3.3,1,1,false, "");

    Rent r1 = new Rent(999,100,3, LocalDate.of(2022,10,10), null);
    Rent r2 = new Rent(899,200,2, LocalDate.of(2021,11,11), null);
    Rent r3 = new Rent(799,300,1, LocalDate.of(2020,12,12), null);


    @Test
    @Order(1)
    public void createTest() {
        try(ClientRepository clientRepository = new ClientRepository();
            RentManager rentRepository = new RentManager();
            CourtRepository courtRepository = new CourtRepository()) {

            assertTrue(clientRepository.add(c1));
            assertTrue(clientRepository.add(c2));
            assertTrue(clientRepository.add(c3));

            assertTrue(courtRepository.add(footballCourt));
            assertTrue(courtRepository.add(basketballCourt));
            assertTrue(courtRepository.add(volleyballCourt));

            assertTrue(rentRepository.add(r1));
            assertTrue(rentRepository.add(r2));
            assertTrue(rentRepository.add(r3));

        } catch(Exception e) {
            return;
        }
    }


    @Test
    @Order(2)
    public void courtMapperTest() {


    }
}
