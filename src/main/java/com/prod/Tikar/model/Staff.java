package com.prod.Tikar.model;

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

        this.role = role;
        this.isActive = isActive;
    }

    public Staff() {
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

    StaffRole role;

    // @OneToMany
    // @Column(nullable = true)
    // List<Asset> assets;

}
