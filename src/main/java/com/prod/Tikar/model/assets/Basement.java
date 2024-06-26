package com.prod.Tikar.model.assets;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Staff;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Basement extends Asset {

    long numberOfHalls;

    String type;
    boolean isActive;

    @ManyToOne
    Building building;

    public Basement(long numberOfHalls, BasementType type, boolean isActive, Building building, String description,
            int surfaceArea, long estimatedValue, Byte[] image, Staff staff, AssetType assetType) {
        super(staff, description, surfaceArea,
                estimatedValue, image, isActive, assetType);
        this.numberOfHalls = numberOfHalls;
        this.type = type.name();
        this.isActive = isActive;
        this.building = building;
        // this.lessor = lessor;

    }

    public Basement() {
        super();
    }
}
