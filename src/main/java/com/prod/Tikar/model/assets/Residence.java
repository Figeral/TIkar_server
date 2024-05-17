package com.prod.Tikar.model.assets;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Staff;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Residence extends Asset {

    public Residence(Lessor lessor, Staff staff, Long matricule, String name, String address, String ville,
            String description,
            long surfaceArea, long estimatedValue, Byte[] image, long numberOfHalls, boolean isActive,
            AssetType assetType) {
        super(lessor, staff, matricule, name, address, ville, description, surfaceArea, estimatedValue, image,
                isActive,
                assetType);
        this.numberOfHalls = numberOfHalls;
    }

    public Residence() {
        super();
    }
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // long id;

    long numberOfHalls;
}
