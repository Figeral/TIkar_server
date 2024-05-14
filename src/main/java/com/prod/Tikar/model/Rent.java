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

  boolean isActive;

  public Rent(Date startDate, Date endDate, long cost, Renter renter, List<Asset> asset, boolean isActive) {
    this.EndArt = endDate;
    this.startAt = startDate;
    this.cost = cost;
    this.renter = renter;
    this.asset = asset;
    this.isActive = isActive;
  }
  // todo: still have to implement the constructor, entity association with Renter
  // and Asset abstract class
}