package com.example.member_management_p3.Service;

import com.example.member_management_p3.DAO.EquipmentDAO;
import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Responsitory.EquipmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentDAO equipmentDAO;

    public EquipmentService(EquipmentDAO equipmentDAO) {
        this.equipmentDAO = equipmentDAO;
    }

    public List<Equipment> getAllEquipment(){
        return equipmentDAO.getAllEquipment();
    }

    public List<Equipment> getEquipmentByName(String tenTB){
        return equipmentDAO.getEquipmentByName(tenTB);
    }

    public Equipment getEquipmentById(int id){
        return equipmentDAO.getEquipmentById(id);
    }

    public Boolean bookingEquipment(int id, LocalDateTime timeNow){
        return equipmentDAO.checkEquipment(id, timeNow);
    }
}
