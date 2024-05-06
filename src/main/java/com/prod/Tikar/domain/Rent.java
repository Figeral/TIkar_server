package com.prod.Tikar.domain;

import java.sql.*;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Date startAt;
    Date EndArt;

  // todo: still have to implement the constructor, entity association with Renter and Asset abstract class
  
}
