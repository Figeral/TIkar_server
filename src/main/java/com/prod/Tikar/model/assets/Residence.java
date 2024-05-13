package com.prod.Tikar.model.assets;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Staff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Residence extends Asset {

    public Residence(Lessor lessor, Staff staff, int matricule, String name, String address, String description,
            long surfaceArea, long estimatedValue, Byte[] image, long numberOfHalls, boolean isActive) {
        super(lessor, staff, matricule, name, address, description, surfaceArea, estimatedValue, image, isActive);
        this.numberOfHalls = numberOfHalls;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long numberOfHalls;

    // @Override
    // public String getAssetType() {

    // return "residence";
    // }
}
