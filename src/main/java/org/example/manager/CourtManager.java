package org.example.manager;

import org.example.entity.Court;
import org.example.repository.Repository;

public class CourtManager extends Manager<Court> {

    public CourtManager(Repository<Court> repository) {
        super(repository);
    }
}
