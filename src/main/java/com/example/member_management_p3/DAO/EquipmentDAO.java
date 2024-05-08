package com.example.member_management_p3.DAO;

import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Responsitory.EquipmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentDAO {
    @Autowired
    EquipmentRespository equipmentRespository;

    public List<Equipment> getAllEquipment(){
        List<Equipment> equipmentList = equipmentRespository.findAll();
        return equipmentList;
    }


}
