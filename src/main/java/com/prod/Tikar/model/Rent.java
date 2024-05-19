package com.prod.Tikar.model;

import java.sql.*;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  Date startAt;
  Date EndAt;
  long cost;

  // @JsonIgnore
  @OneToOne
  Asset asset;

  @OneToOne // List<Asset> asset;
  Renter renter;

  boolean isActive;

  // public Rent(Date startDate, Date endDate, long cost, Renter renter,
  // List<Asset> asset, boolean isActive) {

  public Rent(Date startDate, Date endDate, long cost, Renter renter, Asset asset, boolean isActive) {
    this.EndAt = endDate;
    this.startAt = startDate;
    this.cost = cost;
    this.renter = renter;
    this.asset = asset;
    this.isActive = isActive;
  }

  public Rent() {
  }
  // todo: still have to implement the constructor, entity association with Renter
  // and Asset abstract class
}
