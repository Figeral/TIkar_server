package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Renter {
    public Renter(String fname, String lname, Integer tel, Byte[] picture, boolean isActive) {
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.picture = picture;
        // this.rent = rent;
        this.isActive = isActive;
    }

public Renter(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String fname, lname;
    Integer tel;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    Byte[] picture;

    @OneToMany
    List<Rent> rent;

    boolean isActive;
    // todo: still have to implement the constructor, entity association with Rent
    // and Asset abstract class
}
