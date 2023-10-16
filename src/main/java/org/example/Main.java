package org.example;

import org.example.entity.Client;
import org.example.repository.ClientRepository;

public class Main {
    public static void main(String[] args) {
        try (ClientRepository clientRepository = new ClientRepository()) {
            Client client = new Client("adfad","Adsfadf","4354w");
            System.out.println(clientRepository.add(client));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}