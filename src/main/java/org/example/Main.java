package org.example;

import org.example.entity.Client;
import org.example.entity.Court;
import org.example.entity.Rent;
import org.example.manager.ClientManager;
import org.example.manager.CourtManager;
import org.example.manager.RentManager;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try (RentManager rentManager = new RentManager(new RentRepository());
             CourtManager courtManager = new CourtManager(new CourtRepository());
             ClientManager clientManager = new ClientManager(new ClientRepository())){

//            Client client = new Client("Jakub","XYZ","abc123");
//            cilentRepository.add(client);
//
//            BasketballCourt bCourt = new BasketballCourt(
//                    10, 10, 10, 10);
//
//            courtRepository.add(bCourt);
//            FootballCourt footballCourt = new FootballCourt(20, 20, 20, 20);
//            courtManager.add(footballCourt);

            Court bCourt = courtManager.find(2);
            Client client = clientManager.find(1);

            Rent rent1 = new Rent(
                    LocalDateTime.of(2023,10,21,17,0),
                    LocalDateTime.of(2023,10,21,18,0),
                    bCourt,
                    client
            );

            System.out.println(rentManager.add(rent1));

//            RentManager rentManager = new RentManager();
//
//            System.out.println(rentManager.add(rent1));

//            Rent rent2 = new Rent(
//                    LocalDateTime.of(2023,10,16,15,30),
//                    LocalDateTime.of(2023,10,16,16,30),
//                    bCourt,
//                    client
//            );
//            Rent rent3 = new Rent(
//                    LocalDateTime.of(2023,10,16,17,30),
//                    LocalDateTime.of(2023,10,16,18,30),
//                    bCourt,
//                    client
//            );
//
//            rentRepository.add(rent1);
//            rentRepository.add(rent2);
//            rentRepository.add(rent3);

//            List<Rent> rentList = rentRepository.findByCourtId(1);
//            for (Rent rent : rentList) {
//                System.out.println(rent);;
//            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}