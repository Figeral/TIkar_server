package com.prod.Tikar.model.assets;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Basement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long numberOfHalls;
    // BasementType type;
    String type;
    boolean isActive;
    Building building;

    public Basement(long numberOfHalls, BasementType type, boolean isActive, Building building) {
        this.numberOfHalls = numberOfHalls;
        this.type = type.name();
        this.isActive = isActive;
        this.building = building;
    }
}
