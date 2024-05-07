package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Model.Usage;
import com.example.member_management_p3.Repository.EquipmentRepository;
import com.example.member_management_p3.Repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private UsageRepository usageRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Usage> getAllUsages() {
        return usageRepository.findAll();
    }

    public Equipment getEquipmentById(Integer equipmentId) {
        return equipmentRepository.findById(equipmentId).orElse(null);
    }
}
