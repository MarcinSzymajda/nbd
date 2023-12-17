package org.example;

import org.example.entity.Client;
import org.example.repository.ClientRepository;
import org.example.repository.RentRepository;

public class Main {
    public static void main(String[] args) throws Exception {

        Client c1 = new Client(4,true,"Marcin",   "Szymajda","123");
//        Client c2 = new Client("Jakub","Osypiuk","456");
//        Client c3 = new Client("Dominik","Marzec","123567");

        ClientRepository repository = new ClientRepository();
//        repository.add(c1);
        Client fromCassandra = repository.find(4);
        System.out.println(fromCassandra);

        System.out.println(repository.remove(4));
    }
}