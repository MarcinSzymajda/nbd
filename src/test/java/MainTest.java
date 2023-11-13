import org.example.entity.BasketballCourt;
import org.example.entity.Client;
import org.example.entity.FootballCourt;
import org.example.entity.VolleyballCourt;
import org.example.entityMgd.*;
import org.example.mapper.ClientMapper;
import org.example.mapper.CourtMapper;
import org.example.repository.*;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    @Test
    public void testClientRepo() {
        try (ClientRepository clientRepository = new ClientRepository()) {
            ClientMgd clientMgd = new ClientMgd(1, "Marek", "Blok", "3424", 0);

            // create
            assertTrue(clientRepository.add(clientMgd));

            // read
            ClientMgd mongoClient = clientRepository.find(clientMgd.getId());
            assertEquals(clientMgd.getId(), mongoClient.getId());

            // update
            mongoClient.setFirstName("XXXX");
            assertTrue(clientRepository.update(mongoClient));
            ClientMgd updatedMongoClient = clientRepository.find(mongoClient.getId());
            assertEquals(mongoClient.getFirstName(), updatedMongoClient.getFirstName());

            // delete
            assertTrue(clientRepository.remove(clientMgd.getId()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testBasketRepo() {

        try (BasketballCourtRepository basketRepo = new BasketballCourtRepository()) {
            BasketballCourtMgd basketcourtMgd = new BasketballCourtMgd(99, 999, 999, 0, 999, 999);

            //add
            assertTrue(basketRepo.add(basketcourtMgd));

            //read
            BasketballCourtMgd mongoRead = basketRepo.find(basketcourtMgd.getId());
            assertEquals(mongoRead.getId(),basketcourtMgd.getId());

            //update
            mongoRead.setLength(321.5);
            assertTrue(basketRepo.update(mongoRead));
            BasketballCourtMgd mongoUpdated = basketRepo.find(basketcourtMgd.getId());
            assertEquals(mongoUpdated.getLength(),mongoRead.getLength());

            //delete
            assertTrue(basketRepo.remove(basketcourtMgd.getId()));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testFootballRepo() {

        try (FootballCourtRepository footballRepo = new FootballCourtRepository()) {

            FootballCourtMgd footballCourtMgd = new FootballCourtMgd(5, 1,1,0,1,1);

            //add
            assertTrue(footballRepo.add(footballCourtMgd));

            //read
            FootballCourtMgd mongoRead = footballRepo.find(footballCourtMgd.getId());
            assertEquals(mongoRead.getId(),footballCourtMgd.getId());

            //update
            mongoRead.setLength(100);
            assertTrue(footballRepo.update(mongoRead));
            FootballCourtMgd mongoUpdated = footballRepo.find(footballCourtMgd.getId());
            assertEquals(mongoUpdated.getLength(),mongoRead.getLength());

            //delete
            assertTrue(footballRepo.remove(footballCourtMgd.getId()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testVolleyballRepo() {

        try (VoleyballCourtRepository volleyballRepo = new VoleyballCourtRepository()) {

            VolleyballCourtMgd volleyballCourtMgd = new VolleyballCourtMgd(10, 1,1,0,1,1);

            //add
            assertTrue(volleyballRepo.add(volleyballCourtMgd));

            //read
            VolleyballCourtMgd mongoRead = volleyballRepo.find(volleyballCourtMgd.getId());
            assertEquals(mongoRead.getId(),volleyballCourtMgd.getId());

            //update
            mongoRead.setLength(100);
            assertTrue(volleyballRepo.update(mongoRead));
            VolleyballCourtMgd mongoUpdated = volleyballRepo.find(volleyballCourtMgd.getId());
            assertEquals(mongoUpdated.getLength(),mongoRead.getLength());

            //delete
            assertTrue(volleyballRepo.remove(volleyballCourtMgd.getId()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMapping() {
        VolleyballCourt volleyballCourt = new VolleyballCourt(10, 1,1,0,1,1);
        FootballCourt footballCourt = new FootballCourt(5, 1,1,0,1,1);
        BasketballCourt basketballCourt = new BasketballCourt(43, 53,43,0,1,1);
        Client client = new Client(3, "Adam", "Spadam", "454545", 0);


        VolleyballCourtMgd volleyballCourtMgd = CourtMapper.toMongoVolleyballCourt(volleyballCourt);
        BasketballCourtMgd basketballCourtMgd = CourtMapper.toMongoBasketballCourt(basketballCourt);
        FootballCourtMgd footballCourtMgd = CourtMapper.toMongoFootballCourt(footballCourt);
        ClientMgd clientMgd = ClientMapper.toMongoClient(client);

        VolleyballCourt volleyConverted = CourtMapper.fromMongoCourtToVolleyballCourt(volleyballCourtMgd);
        BasketballCourt basketConverted = CourtMapper.fromMongoCourtToBasketballCourt(basketballCourtMgd);
        FootballCourt footConverted = CourtMapper.fromMongoCourtToFootballCourt(footballCourtMgd);
        Client clientConverted = ClientMapper.fromMongoClient(clientMgd);

        assertEquals(volleyConverted, volleyballCourt);
        assertEquals(basketConverted, basketballCourt);
        assertEquals(footConverted, footballCourt);
        assertEquals(clientConverted, client);

    }

    @Test
    public void testRentLogic() {
        try(ClientRepository clientRepository = new ClientRepository();
            FootballCourtRepository footballCourtRepository = new FootballCourtRepository();
            RentRepository rentRepository = new RentRepository()) {

            FootballCourtMgd footballCourtMgd = new FootballCourtMgd(25, 1,1,0,1,1);
            ClientMgd clientMgd = new ClientMgd(25, "Marek", "Blok", "3424", 0);

            assertTrue(clientRepository.add(clientMgd));
            assertTrue(footballCourtRepository.add(footballCourtMgd));

            RentMgd rentMgd = new RentMgd(25, footballCourtMgd, clientMgd, LocalDateTime.now());
            assertTrue(rentRepository.add(rentMgd));

            FootballCourtMgd mongoCourt = footballCourtRepository.find(footballCourtMgd.getId());
            ClientMgd mongoClient = clientRepository.find(clientMgd.getId());
            assertEquals(mongoCourt.getIsRented(), 1);
            assertEquals(mongoClient.getHasRent(), 1);
        }
    }
}
