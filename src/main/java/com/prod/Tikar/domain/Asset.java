package com.prod.Tikar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Asset {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   long id;

   int matricule; // keeping in mind that an id already uniquely identifies this entity
   String name;
   String address;

   @Column(nullable = true)
   String description;
   long surfaceArea;
   long estimatedValue;
   Byte image;

   public abstract String getAssetType();

   // todo: still have to implement the constructor, entity association with Renter and Rent class

}
