package com.prod.Tikar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.prod.Tikar.model.Lessor;

import jakarta.transaction.Transactional;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Long> {
    @Modifying
    @Transactional
    @Query(value = "update lessor l set l.is_active = :isActive, l.tel = :tel, l.fname = :fname, l.lname = :lname, l.picture = :pic where id = :index", nativeQuery = true)
    int updateLessor(@Param("index") Long index, @Param("isActive") boolean isActive, @Param("tel") Integer tel,
            @Param("fname") String fname, @Param("lname") String lname, @Param("pic") Byte[] pic);
}
