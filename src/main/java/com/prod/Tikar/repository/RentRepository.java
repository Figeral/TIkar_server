package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}
