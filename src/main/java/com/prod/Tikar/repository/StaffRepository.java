package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
