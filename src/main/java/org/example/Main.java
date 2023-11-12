package org.example;

import org.example.entityMgd.ClientMgd;
import org.example.entityMgd.CourtMgd;
import org.example.entityMgd.FootballCourtMgd;
import org.example.entityMgd.RentMgd;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;
import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ClientMgd clientMgd = new ClientMgd(44, "Marek", "Blok", "3424");
        FootballCourtMgd courtMgd = new FootballCourtMgd(44, 999, 999, 999,999);

        try(ClientRepository clientRepository  = new ClientRepository();
            CourtRepository courtRepository = new CourtRepository();
            RentRepository rentRepository = new RentRepository()) {

//            System.out.println(clientRepository.add(clientMgd));
//            System.out.println(courtRepository.add(courtMgd));
//
//            RentMgd rentMgd = new RentMgd(44, courtMgd, clientMgd, LocalDateTime.now());
//            System.out.println(rentRepository.add(rentMgd));

//            ClientMgd mongoClient = clientRepository.find(11);
            CourtMgd mongoCourt = courtRepository.find(54);
            System.out.println();
//
//            RentMgd mongoRent = rentRepository.find(44);
//            System.out.println(rentRepository.endRent(mongoRent));

//            System.out.println(courtRepository.update(courtMgd));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}