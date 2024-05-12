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
    BasementType type;

    public Basement(long numberOfHalls, BasementType type) {
        this.numberOfHalls = numberOfHalls;
        this.type = type;
    }
}
