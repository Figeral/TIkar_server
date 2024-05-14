package com.prod.Tikar.model.assets;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Lessor;
import com.prod.Tikar.model.Staff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Basement extends Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long numberOfHalls;
    // BasementType type;
    String type;
    boolean isActive;

    @ManyToOne
    Building building;
    @ManyToOne
    Lessor lessor;

    @ManyToOne
    Staff staff;

    public Basement(long numberOfHalls, BasementType type, boolean isActive, Building building, String description,
            int surfaceArea, long estimatedValue, Byte[] image, Lessor lessor, Staff staff) {
        super(lessor, staff, description, surfaceArea,
                estimatedValue, image, isActive);
        this.numberOfHalls = numberOfHalls;
        this.type = type.name();
        this.isActive = isActive;
        this.building = building;
        this.lessor = lessor;
        this.staff = staff;
    }
}
