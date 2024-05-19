package com.prod.Tikar.model.assets;

import java.util.List;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Staff;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

@Setter
@Getter
public class Building extends Asset {
    public Building(Lessor lessor, Staff staff, Long matricule, String name, String address, String ville,
            String description,
            long surfaceArea, long estimatedValue, Byte[] image, long numberOfFloors,
            boolean isActive, AssetType assetType) {
        super(lessor, staff,
                matricule, name, address, ville, description, surfaceArea, estimatedValue, image,
                isActive,
                assetType);
        // this.basement = basement;
        this.numberOfFloors = numberOfFloors;
    }

    public Building() {
        super();
    }
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // long id;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    List<Basement> basement;

    long numberOfFloors;

}