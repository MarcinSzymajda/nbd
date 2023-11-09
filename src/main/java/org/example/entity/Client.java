package org.example.entity;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;


public class Client extends AbstractEntityMgd{

    @BsonProperty("firstName")
    private String firstName;
    @BsonProperty("lastName")
    private String lastName;
    @BsonProperty("personalId")
    private String personalID;
    @BsonProperty("hasRent")
    private boolean hasRent;
    @BsonProperty("rent")
    private List<Rent> rents;

    @BsonCreator
    public Client(@BsonProperty("_id") int id,
                  @BsonProperty("firstName") String firstName,
                  @BsonProperty("lastName") String lastName,
                  @BsonProperty("personalId") String personalID) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public boolean isHasRent() {
        return hasRent;
    }

    public void setHasRent(boolean hasRent) {
        this.hasRent = hasRent;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
