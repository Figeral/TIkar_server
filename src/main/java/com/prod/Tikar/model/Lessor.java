package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String fname, lname;
    Integer tel;
    Byte picture;

    @OneToMany
    List<Asset> assets;

    public Lessor(String fname, String lname, Integer tel, Byte picture, List<Asset> assets) {
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.picture = picture;
        this.assets = assets;
    }

}
