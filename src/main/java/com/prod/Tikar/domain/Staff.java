package com.prod.Tikar.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    
    String fname,Lname;
    Integer Tel;
    Byte image;
    public abstract String getStaffType();
    

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return Lname;
    }
    public void setLname(String lname) {
        Lname = lname;
    }
    
}
