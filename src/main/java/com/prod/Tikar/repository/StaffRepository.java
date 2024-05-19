package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.Staff;

import jakarta.transaction.Transactional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Transactional
    @Modifying
    @Query(value = "update staff set staff.is_active= :isActive , role= :role, tel= :tel, f_name= :fname, l_name= :lname , password = :password, picture = :pic  where id= :index", nativeQuery = true)
    int updateStaff(@Param(value = "index") int index,
            @Param(value = "isActive") boolean isActive,
            @Param(value = "role") String role,
            @Param(value = "tel") Integer tel,
            @Param(value = "fname") String fname,
            @Param(value = "lname") String lname,
            @Param(value = "password") String password,
            @Param(value = "pic") Byte[] pic);

}
