package com.prod.Tikar.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@Table
public class Staff {
    public Staff(String fname, String lname, String password, Integer tel, Byte[] picture,

            StaffRole role,
            boolean isActive) {
        this.fName = fname;

        this.lName = lname;
        this.password = password;
        this.tel = tel;
        this.picture = picture;
        // this.isAdmin = isAdmin;
        // this.isManagement = isManagement;
        // this.isExtern = isExtern;
        // this.assets = assets;
        this.role = role;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String fName, password;

    @Column(nullable = true)
    String lName;

    Integer tel;

    @Column(nullable = true)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    Byte[] picture;

    boolean isActive;
    // Boolean isAdmin;
    // Boolean isManagement;
    // Boolean isExtern;
    StaffRole role;

    @OneToMany
    @Column(nullable = true)
    List<Asset> assets;

    // public abstract String getStaffType();
}
