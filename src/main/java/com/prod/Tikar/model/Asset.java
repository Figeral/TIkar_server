package com.prod.Tikar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Asset {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   long id;

   public Asset(Lessor lessor, Staff staff, int matricule, String name, String address, String description,
         long surfaceArea,
         long estimatedValue, Byte image) {
      this.lessor = lessor;
      this.addedBy = staff;
      this.matricule = matricule;
      this.name = name;
      this.address = address;
      this.description = description;
      this.surfaceArea = surfaceArea;
      this.estimatedValue = estimatedValue;
      this.image = image;

   };

   @ManyToOne
   Lessor lessor;

   @ManyToOne
   @JoinColumn(name = "addedBy")
   Staff addedBy;

   @Column(nullable = true)
   int matricule; // keeping in mind that an id already uniquely identifies this entity
   String name;
   String address;

   @Column(nullable = true)
   String description;
   long surfaceArea;
   long estimatedValue;
   Byte image;

   public String getAssetType() {
      return "";
   }

   // todo: still have to implement the constructor, entity association with Renter
   // and Rent class

}
