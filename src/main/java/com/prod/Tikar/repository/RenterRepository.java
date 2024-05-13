package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {

}
