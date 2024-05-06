package com.prod.Tikar.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Staff{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long Id;
    String fname,lname,password;
    Integer  tel;
    Byte picture;
    
   public abstract String getStaffType();
}
