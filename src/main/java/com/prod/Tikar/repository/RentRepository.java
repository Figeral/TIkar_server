package com.prod.Tikar.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prod.Tikar.model.Asset;
import com.prod.Tikar.model.Rent;
import com.prod.Tikar.model.Renter;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    @Transactional
    @Modifying
    @Query(value = "update rent set isActive= :active, asset_id= :asset.id , renter_id= :renter.id, cost= :cost, startAt= :startAt, endAt= :endAt where id= :index", nativeQuery = true)
    int updateRent(@Param(value = "index") int index,
            @Param(value = "active") boolean active,
            @Param(value = "asset") Asset asset,
            @Param(value = "renter") Renter renter,
            @Param(value = "cost") long cost,
            @Param(value = "startAt") Date startAt,
            @Param(value = "endAt") Date endAt);
}
