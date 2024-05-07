package com.example.member_management_p3.Repository;

import com.example.member_management_p3.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
