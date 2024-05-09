package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Model.Usage;
import com.example.member_management_p3.Repository.UsageRepository;
import com.example.member_management_p3.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private UsageRepository usageRepository;


    @GetMapping
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/admin/showEquipment")
    public String showEquipmentPage(Model model) {
        List<Integer> unreturnedEquipmentIds = usageRepository.findUnreturnedEquipmentIds();
        Map<Integer, Boolean> isReturnedMap = new HashMap<>();
        Usage usage = new Usage();
        List<Equipment> equipments= equipmentService.getAllEquipments();
        for (Equipment equipment : equipments) {
            boolean isReturned = !unreturnedEquipmentIds.contains(equipment.getMaTB());
            isReturnedMap.put(equipment.getMaTB(), isReturned);
        }
        model.addAttribute("isReturnedMap", isReturnedMap);
        model.addAttribute("usage",usage);
        model.addAttribute("equipments",equipments);
        return "admin/equipment/equipment";
    }

    @GetMapping("/equipment/addPage")
    public String showAddEquipment(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment",equipment);
        return "/admin/equipment/addEquipment";
    }

    @GetMapping("/equipment/excelPage")
    public String showExcelPage(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment",equipment);
        return "/admin/equipment/equipmentExcel";
    }

    @GetMapping("/equipment/getByID")
    public ResponseEntity<Equipment> getEquipmentById(Integer maTB) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(maTB);
        return equipment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/equipment/add")
    public String createEquipment(@ModelAttribute("equipment") Equipment equipment) {
        try {
            equipmentService.createEquipment(equipment);
            return "/admin/equipment/addEquipment";
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Thêm thất bại: " + e.getMessage()).toString();
        }
    }

    @PostMapping("/equipment/addAll")
    public ResponseEntity<String> addAllEquipments(@RequestBody List<Equipment> equipments) {
        try {
            for (Equipment equipment : equipments) {
                equipmentService.createEquipment(equipment);
            }
            return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Thêm thất bại: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/equipment/update")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Integer maTB, @RequestBody Equipment equipment) {
        Optional<Equipment> existingEquipment = equipmentService.getEquipmentById(maTB);
        if (existingEquipment.isPresent()) {
            equipment.setMaTB(maTB);
            return new ResponseEntity<>(equipmentService.updateEquipment(equipment), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/equipment/delete")
    public ResponseEntity<Equipment> deleteEquipment(@RequestParam Integer maTB) {
        Optional<Equipment> existingEquipment = equipmentService.getEquipmentById(maTB);
        if (existingEquipment.isPresent()) {
            Equipment equipment = existingEquipment.get();
            equipment.setMo_tatb("deleted");
            return new ResponseEntity<>(equipmentService.updateEquipment(equipment), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
