package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Renter {
    public Renter(String fname, String lname, Integer tel, Byte picture, List<Rent> rent) {
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.picture = picture;
        this.rent = rent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String fname, lname;
    Integer tel;
    Byte picture;
    @OneToMany
    List<Rent> rent;
    // todo: still have to implement the constructor, entity association with Rent
    // and Asset abstract class
}
