package org.example;

import org.example.entity.*;
import org.example.manager.RentManager;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        Client c1 = new Client(3,false,"Marcin",   "Szymajda","123");

        Rent r1 = new Rent(999,100,3, LocalDate.of(2022,10,10), null);

        FootballCourt footballCourt = new FootballCourt(100,1.1,1.1,1,1,false, "");
        VolleyballCourt volleyballCourt = new VolleyballCourt(200,2.2,2.2,1,1,false, "");
        BasketballCourt basketballCourt = new BasketballCourt(300,3.3,3.3,1,1,false, "");

        ClientRepository clientRepository = new ClientRepository();
        RentRepository rentRepository = new RentRepository();
        CourtRepository courtRepository = new CourtRepository();

        // MANAGER
        RentManager rentManager = new RentManager();

//        System.out.println(rentManager.addRent(r1));
//        System.out.println(rentManager.endRent(r1));
        // INSERT
//        clientRepository.add(c1);
//
//      rentRepository.add(r1);
//
//        courtRepository.add(footballCourt);
//        courtRepository.add(volleyballCourt);
//        courtRepository.add(basketballCourt);

        // READ UPDATE
//        Client cc = clientRepository.find(1);
//        cc.setFirstName("New Name");
//        clientRepository.update(cc);
//
//        Rent cr = rentRepository.find(1);
//        cr.setEndTime(LocalDate.of(2022, 10, 5));
//        rentRepository.update(cr);
//
//        FootballCourt fc = (FootballCourt) courtRepository.find(100);
//        fc.setGoalLength(999);
//        courtRepository.update(fc);
//
//        VolleyballCourt vc = (VolleyballCourt) courtRepository.find(200);
//        vc.setNetLength(999);
//        courtRepository.update(vc);
//
//        BasketballCourt bc = (BasketballCourt) courtRepository.find(300);
//        bc.setBasketHeight(999);
//        courtRepository.update(bc);

//        // DELETE
//        clientRepository.remove(1);
//
//        rentRepository.remove(1);
//
//        courtRepository.remove(100);
//        courtRepository.remove(200);
//        courtRepository.remove(300);
    }
}