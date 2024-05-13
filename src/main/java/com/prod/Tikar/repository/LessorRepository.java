package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.Tikar.model.Lessor;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Long> {

}
