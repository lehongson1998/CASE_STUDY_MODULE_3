package model.person.customer;

import model.person.Person;

import java.time.LocalDate;
import java.util.Date;

public class Customer extends Person {
    private int typeCustomerId;
    private int gender;


    public Customer(int id, String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, int typeCustomerId, int gender) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
        this.typeCustomerId = typeCustomerId;
        this.gender = gender;
    }

    public int getTypeCustomerId() {
        return typeCustomerId;
    }

    public void setTypeCustomerId(int typeCustomerId) {
        this.typeCustomerId = typeCustomerId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
