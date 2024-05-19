package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prod.Tikar.model.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
    @Transactional
    @Modifying
    @Query(value = "update renter r set r.isActive= :active, r.tel= :tel, r.fname= :fname, r.lname= :lname, r.picture= :picture where r.id= :index", nativeQuery = true)
    int updateStaff(@Param(value = "index") int index,
            @Param(value = "active") boolean active,
            @Param(value = "tel") Integer tel,
            @Param(value = "fname") String fname,
            @Param(value = "lname") String lname,
            @Param(value = "picture") Byte[] picture);

}
