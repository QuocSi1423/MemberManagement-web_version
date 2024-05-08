package com.example.member_management_p3.Responsitory;

import com.example.member_management_p3.Model.Entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRespository extends JpaRepository<Equipment, Long> {
}
