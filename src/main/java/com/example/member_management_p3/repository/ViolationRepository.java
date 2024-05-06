package com.example.member_management_p3.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.member_management_p3.model.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {
    @Query("SELECT v FROM Violation v WHERE v.status = :status AND v.date >= :startDate AND v.date <= :endDate")
    List<Violation> getViolationListByFilter(@Param("status") Integer status, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}