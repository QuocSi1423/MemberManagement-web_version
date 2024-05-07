package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(Integer maTB) {
        return equipmentRepository.findById(maTB);
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Integer maTB) {
        equipmentRepository.deleteById(maTB);
    }
}
