package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EquipmentController {
    private EquipmentService equipmentService;

    @GetMapping("/user/equipment")
    public String equipment(Model model){
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        model.addAttribute("equipmentList", equipmentList);
        return "user/equipment";
    }
}