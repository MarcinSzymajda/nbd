package org.example;

import org.example.entity.Client;
import org.example.repository.CilentRepository;

public class Main {
    public static void main(String[] args) {
        CilentRepository cilentRepository = new CilentRepository();

        Client client = new Client("Jakub","XYZ","abc123");
        cilentRepository.remove(2);
    }
}