package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.assets.Basement;

@Repository
public interface BasementRepository extends JpaRepository<Basement, Long> {

}
