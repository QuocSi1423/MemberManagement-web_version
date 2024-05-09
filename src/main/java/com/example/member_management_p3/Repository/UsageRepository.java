package com.example.member_management_p3.Repository;

import com.example.member_management_p3.Model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Integer> {
    @Query("SELECT u.equipmentId FROM Usage u WHERE u.borrowingTime IS NOT NULL AND u.returnTime IS NULL")
    List<Integer> findUnreturnedEquipmentIds();
}