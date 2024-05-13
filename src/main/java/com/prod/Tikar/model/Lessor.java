package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    @Lob
    @Basic(fetch = FetchType.LAZY)
    Byte[] picture;

    boolean isActive;

    @OneToMany
    List<Asset> assets;

    public Lessor(String fname, String lname, Integer tel, Byte[] picture, boolean isActive) {
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.picture = picture;
        // this.assets = assets;
        this.isActive = isActive;
    }

}
