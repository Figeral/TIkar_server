package com.prod.Tikar.model;

import java.sql.*;
import java.util.List;

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
  long cost;

  @OneToMany
  List<Asset> asset;

  @ManyToOne
  Renter renter;

  public Rent(Date startDate, Date endDate, long cost, Renter renter, List<Asset> asset) {
    this.EndArt = endDate;
    this.startAt = startDate;
    this.cost = cost;
    this.renter = renter;
    this.asset = asset;
  }
  // todo: still have to implement the constructor, entity association with Renter
  // and Asset abstract class
}