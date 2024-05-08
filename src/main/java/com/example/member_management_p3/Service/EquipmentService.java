package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Responsitory.EquipmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRespository equipmentRespository;

    public List<Equipment> getAllEquipment(){
        return equipmentRespository.findAll();
    }
}
