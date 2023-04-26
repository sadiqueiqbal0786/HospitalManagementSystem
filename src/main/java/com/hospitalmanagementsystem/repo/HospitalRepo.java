package com.hospitalmanagementsystem.repo;

import com.hospitalmanagementsystem.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalRepo extends JpaRepository<Hospital,Long> {
    @Query(value = "select * from hospital l where l.doctor_name like %:keyword% or l.patient_name like %:keyword%", nativeQuery = true)
    List<Hospital> findByKeyword(@Param("keyword") String keyword);
}
