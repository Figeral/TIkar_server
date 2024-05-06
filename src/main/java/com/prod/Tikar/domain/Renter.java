package com.prod.Tikar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String fname,lname;
    Integer tel;
    Byte picture;

    // todo: still have to implement the constructor, entity association with Rent and Asset abstract class
}
