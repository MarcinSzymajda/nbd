import org.example.entity.*;
import org.example.manager.RentManager;
import org.example.repository.ClientRepository;
import org.example.repository.CourtRepository;
import org.example.repository.RentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class MainTest {

    Client c1 = new Client("Marcin","Szymajda","123");
    Client c2 = new Client("Jakub","Osypiuk","456");
    Client c3 = new Client("Dominik","Marzec","123567");

    Court co1 = new FootballCourt(25.5,12.3,3.25,2.25);
    Court co2 = new BasketballCourt(22.4,21.5,2.8,1.1);
    Court co3 = new VolleyballCourt(15.2,13.2,1.25,15.0);


}
