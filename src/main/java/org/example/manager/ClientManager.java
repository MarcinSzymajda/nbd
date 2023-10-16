package org.example.manager;

import org.example.entity.Client;
import org.example.repository.Repository;

public class ClientManager extends Manager<Client> {

    public ClientManager(Repository<Client> repository) {
        super(repository);
    }
}
