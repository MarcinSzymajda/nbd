package org.example;

import org.example.entity.Client;
import org.example.repository.CilentRepository;

public class Main {
    public static void main(String[] args) {
        try (CilentRepository cilentRepository = new CilentRepository()){
            Client client = new Client("Jakub","XYZ","abc123");
            cilentRepository.add(client);

            Client newClient = cilentRepository.find(1);
            System.out.println(client.getFirstName() + " = " + newClient.getFirstName());

            cilentRepository.remove(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}