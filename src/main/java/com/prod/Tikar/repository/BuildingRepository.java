package com.prod.Tikar.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prod.Tikar.model.assets.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    // @Transactional
    // @Modifying
    // @Query(value = "update building set isActive= :active,
    // estimatedValue=:estimatedValue where id=:index", nativeQuery = true)

    // int updateRent(@Param(value = "index") int index,
    // @Param(value = "active") boolean active,
    // @Param(value = "ville") String ville,
    // @Param(value = "estimatedValue") Long estimatedValue);

}