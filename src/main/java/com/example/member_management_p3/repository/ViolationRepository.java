package com.example.member_management_p3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.member_management_p3.Model.Violation;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, Integer> {
    @Query("SELECT v FROM Violation v WHERE (:status IS NULL OR v.status = :status) AND (:startDate IS NULL OR v.date >= :startDate) AND (:endDate IS NULL OR v.date <= :endDate)")
    List<Violation> getViolationListByFilter(@Param("status") Integer status, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}