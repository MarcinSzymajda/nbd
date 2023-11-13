package org.example.mapper;

import org.example.entity.Client;
import org.example.entityMgd.ClientMgd;

public class ClientMapper {

    public static Client fromMongoClient(ClientMgd client) {
        return new Client(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getPersonalID(),
                client.getHasRent()
        );
    }

    public static ClientMgd toMongoClient(Client client) {
        return new ClientMgd(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getPersonalID(),
                client.getHasRent()
        );
    }
}
