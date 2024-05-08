package com.example.member_management_p3.Responsitory;

import com.example.member_management_p3.Model.Entity.Booking;
import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Model.Entity.UsageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EquipmentRespository extends JpaRepository<Equipment, Long> {
    @Query("SELECT e FROM Equipment e where e.TenTB like %:tenTB%")
    List<Equipment> findByTenTB(@Param("tenTB") String tenTB);

    @Query("SELECT tb FROM Equipment tb LEFT JOIN UsageInfo tt ON tt.MaTB = :maTB WHERE tt.MaTB IS NULL OR tt.tgtra < :timeNow")
    List<Equipment> getAllEquipmentEmpty(@Param("maTB") int maTB, @Param("timeNow") LocalDateTime timeNow);

    @Query("SELECT m.Hoten, u.tgmuon, u.tgdatcho, e.TenTB, e.MotaTB FROM Equipment e JOIN UsageInfo u ON e.MaTB = :maTB JOIN Member m ON m.MaTV = u.MaTV WHERE e.MaTB = :maTB AND DATE(u.tgdatcho) >= DATE(:timeNow)")
    List<Booking> getBookingsForEquipmentFromDate(@Param("maTB") int maTB, @Param("timeNow") LocalDateTime timeNow);
}
