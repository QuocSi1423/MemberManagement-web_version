package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Entity.Equipment;
import com.example.member_management_p3.Model.Entity.Member;
import com.example.member_management_p3.Model.Entity.UsageInfo;
import com.example.member_management_p3.Service.EquipmentService;
import com.example.member_management_p3.Service.MemberService;
import com.example.member_management_p3.Service.UsageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private UsageInfoService usageInfoService;

    @GetMapping("/reservation")
    public String GetData(Model model) {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("content", "/user/equipment/equipment");
        return "user/index";
    }

    @GetMapping("/user/equipment")
    public String equipment(Model model){
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.getTenTB());
        }
        model.addAttribute("equipmentList", equipmentList);
        return "user/equipment/equipment";
    }

    @GetMapping("/user/equipment/get-equipment-by-name/{name}")
    public String getEquipmentByName(@PathVariable String name, Model model){
        List<Equipment> equipmentList = equipmentService.getEquipmentByName(name);
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.getTenTB());
        }
        model.addAttribute("equipmentList", equipmentList);
        return "user/equipment/equipment";
    }

    @GetMapping("/search")
    public String searchEquipment(@RequestParam("search-equipment") String name, Model model) {
        List<Equipment> equipmentList = equipmentService.getEquipmentByName(name);
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment.getTenTB());
        }
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("content", "/user/equipment/equipment");
        return "user/index";
    }


    public String bookingEquipment(@ModelAttribute UsageInfo usageInfo, Model model, @PathVariable int equipmentId, @PathVariable LocalDateTime timeNow){
        String success = "Thiết bị đã được mượn thành công";
        String err = "Thiết bị đã được mượn thất bại";
        if (equipmentService.bookingEquipment(equipmentId, timeNow)){
            String response = usageInfoService.addUsageInfo(usageInfo);
            model.addAttribute("response", response);
            return "user/equipment/equipment";
        }
        return "user/equipment/equipment";
    }
}