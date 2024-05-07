package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/equipments") // Base path for equipment operations
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/equipment/getByID")
    public ResponseEntity<Equipment> getEquipmentById(Integer maTB) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(maTB);
        return equipment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        Equipment savedEquipment = equipmentService.createEquipment(equipment);
        return new ResponseEntity<>(savedEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/{maTB}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Integer maTB, @RequestBody Equipment equipment) {
        Optional<Equipment> existingEquipment = equipmentService.getEquipmentById(maTB);
        if (existingEquipment.isPresent()) {
            equipment.setMaTB(maTB);
            return new ResponseEntity<>(equipmentService.updateEquipment(equipment), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{maTB}")
    public ResponseEntity<?> deleteEquipment(@PathVariable Integer maTB) {
        equipmentService.deleteEquipment(maTB);
        return ResponseEntity.noContent().build();
    }
}
