import org.example.entity.*;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentManager;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class CRUDTest {

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
    public void createTest() {
        try(ClientRepository clientRepository = new ClientRepository();
            RentManager rentManager = new RentManager();
            CourtRepository courtRepository = new CourtRepository()) {

            assertTrue(clientRepository.add(c1));
            assertTrue(clientRepository.add(c2));
            assertTrue(clientRepository.add(c3));

            assertTrue(courtRepository.add(footballCourt));
            assertTrue(courtRepository.add(basketballCourt));
            assertTrue(courtRepository.add(volleyballCourt));

            assertTrue(rentManager.add(r1));
            assertTrue(rentManager.add(r2));
            assertTrue(rentManager.add(r3));

        } catch(Exception e) {
            return;
        }
    }

    @Test
    public void readTest() {
        try(ClientRepository clientRepository = new ClientRepository();
            RentManager rentManager = new RentManager();
            CourtRepository courtRepository = new CourtRepository()) {

            assertEquals(clientRepository.find(c1.getId()),c1);
            assertEquals(clientRepository.find(c2.getId()),c2);
            assertEquals(clientRepository.find(c3.getId()),c3);

            assertEquals(courtRepository.find(footballCourt.getId()),footballCourt);
            assertEquals(courtRepository.find(basketballCourt.getId()),basketballCourt);
            assertEquals(courtRepository.find(volleyballCourt.getId()),volleyballCourt);

            assertEquals(rentManager.find(r1.getId()),r1);
            assertEquals(rentManager.find(r2.getId()),r2);
            assertEquals(rentManager.find(r3.getId()),r3);


        } catch (Exception e) {
            return;
        }

    }

    @Test
    public void updateTest() {
        try(ClientRepository clientRepository = new ClientRepository();
            RentManager rentRepository = new RentManager();
            CourtRepository courtRepository = new CourtRepository()) {

            //Marcin --> Mateusz
            c1.setFirstName("Mateusz");
            assertTrue(clientRepository.update(c1));

            //1.1 --> 1.67
            footballCourt.setGoalLength(1.67);
            assertTrue(courtRepository.update(footballCourt));

            // 2020-12-12 --> 2019-11-11
            r1.setStartTime(LocalDate.of(2019,11,11));
            assertTrue(rentRepository.update(r1));

        } catch (Exception e) {
            return;
        }

    }


    @Test
    public void deleteTest() {
        try(ClientRepository clientRepository = new ClientRepository();
            RentManager rentManager = new RentManager();
            CourtRepository courtRepository = new CourtRepository()) {

            assertTrue(clientRepository.remove(c1.getId()));
            assertTrue(clientRepository.remove(c2.getId()));
            assertTrue(clientRepository.remove(c3.getId()));
            assertNull(clientRepository.find(c1.getId()));
            assertNull(clientRepository.find(c2.getId()));
            assertNull(clientRepository.find(c3.getId()));

            assertTrue(courtRepository.remove(footballCourt.getId()));
            assertTrue(courtRepository.remove(basketballCourt.getId()));
            assertTrue(courtRepository.remove(volleyballCourt.getId()));
            assertNull(courtRepository.find(footballCourt.getId()));
            assertNull(courtRepository.find(basketballCourt.getId()));
            assertNull(courtRepository.find(volleyballCourt.getId()));

            assertTrue(rentManager.remove(r1.getId()));
            assertTrue(rentManager.remove(r2.getId()));
            assertTrue(rentManager.remove(r3.getId()));
            assertNull(rentManager.find(r1.getId()));
            assertNull(rentManager.find(r2.getId()));
            assertNull(rentManager.find(r3.getId()));

        } catch (Exception e) {
            return;
        }

    }

}
