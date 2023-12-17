package org.example.entity;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;

import java.util.List;


@Entity(defaultKeyspace = "clients")
@CqlName("client")
@PropertyStrategy(mutable = false)
public class Client {

    @PartitionKey
    @CqlName("id")
    private int id;
    @CqlName("hasrent")
    private boolean hasRent;
    @CqlName("firstname")
    private String firstName;
    @CqlName("lastname")
    private String lastName;
    @CqlName("personalid")
    private String personalID;
//    private List<Rent> rents;

    public Client(int id, boolean hasRent, String firstName, String lastName, String personalID) {
        this.id = id;
        this.hasRent = hasRent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
    }

    public Client() {
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public boolean isHasRent() {
        return hasRent;
    }
//    public void setHasRent(boolean hasRent) {
//        this.hasRent = hasRent;
//    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", hasRent=" + hasRent +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalID='" + personalID + '\'' +
                '}';
    }
}
