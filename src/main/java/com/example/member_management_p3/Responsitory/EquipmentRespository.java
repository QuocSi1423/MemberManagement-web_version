package com.example.member_management_p3.Responsitory;

import com.example.member_management_p3.Model.Entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRespository extends JpaRepository<Equipment, Long> {
    @Query("SELECT e FROM Equipment e where e.TenTB like %:tenTB%")
    List<Equipment> findByTenTB(@Param("tenTB") String tenTB);
}
