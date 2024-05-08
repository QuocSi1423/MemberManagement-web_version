package com.example.member_management_p3.DAO;

import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Responsitory.EquipmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipmentDAO {
    @Autowired
    EquipmentRespository equipmentRespository;

    public List<Equipment> getAllEquipment(){
        List<Equipment> equipmentList = equipmentRespository.findAll();
        return equipmentList;
    }

    public List<Equipment> getEquipmentByName(String tenTB){
        List <Equipment> equipmentList = equipmentRespository.findByTenTB(tenTB);
        if (equipmentList.isEmpty()){
            return null;
        }
        return equipmentList;
    }

    public Equipment getEquipmentById(long id){
        Optional<Equipment> e = equipmentRespository.findById((Long) id);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }

    public boolean checkEquipment(int equipmentId, LocalDateTime timeNow){
        List<Equipment> equipmentList = equipmentRespository.getAllEquipmentEmpty(equipmentId, timeNow);
        for (Equipment equipment : equipmentList){
            if (equipment.getMaTB() == equipmentId){
                return true;
            }
        }
        return false;
    }
}
