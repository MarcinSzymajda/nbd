package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    private String firstName;

    private String lastName;

    private String personalID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID;

//    @OneToMany(mappedBy = "client")
//    private List<Rent> rents;

    public Client(String firstName, String lastName, String personalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
    }

    public Client() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public int getClientID() {
        return clientID;
    }
}
