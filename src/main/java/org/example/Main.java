package org.example;

import org.example.entityMgd.ClientMgd;
import org.example.entityMgd.FootballCourtMgd;
import org.example.entityMgd.RentMgd;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        ClientMgd clientMgd = new ClientMgd(55, "Andrzej", "Suwak", "123243", 0);
        FootballCourtMgd courtMgd = new FootballCourtMgd(55, 120, 200, 10,3);


        try(ClientRepository clientRepository  = new ClientRepository();
            CourtRepository courtRepository = new CourtRepository();
            RentRepository rentRepository = new RentRepository()) {

            System.out.println(clientRepository.add(clientMgd));
            System.out.println(courtRepository.add(courtMgd));

            RentMgd rentMgd = new RentMgd(courtMgd, clientMgd, LocalDateTime.now());
            System.out.println(rentRepository.add(rentMgd));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}