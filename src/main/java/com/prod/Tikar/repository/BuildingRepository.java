package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.assets.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
