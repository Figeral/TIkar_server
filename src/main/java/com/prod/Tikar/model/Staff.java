package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Staff {
    public Staff(String fname, String lname, String password, Integer tel, Byte picture, List<Asset> assets,
            StaffRole role) {
        this.fName = fname;
        this.lName = lname;
        this.password = password;
        this.tel = tel;
        this.picture = picture;
        // this.isAdmin = isAdmin;
        // this.isManagement = isManagement;
        // this.isExtern = isExtern;
        this.assets = assets;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String fName, lName, password;
    Integer tel;
    Byte picture;

    // Boolean isAdmin;
    // Boolean isManagement;
    // Boolean isExtern;
    StaffRole role;
    @OneToMany
    List<Asset> assets;
    // public abstract String getStaffType();
}
