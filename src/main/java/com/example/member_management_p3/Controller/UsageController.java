package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Model.Usage;
import com.example.member_management_p3.Model.UsageList;
import com.example.member_management_p3.Service.EquipmentService;
import com.example.member_management_p3.Service.MemberInfoService;
import com.example.member_management_p3.Service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/usages")
public class UsageController {

    @Autowired
    private UsageService usageService;
    @Autowired
    private MemberInfoService memberInfoService;
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Usage> getAllUsages() {
        return usageService.getAllUsage();
    }

    @GetMapping("/usage/getByID")
    public ResponseEntity<Usage> getUsageById(Integer maTT) {
        Optional<Usage> usage = usageService.getUsageById(maTT);
        return usage.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberInfo")
    public ResponseEntity<Member> getMemberInfo(@RequestParam Integer maNV) {
        Optional<Member> member = memberInfoService.getMemberById(maNV);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getEquipmentInfo")
    public ResponseEntity<Equipment> getEquipmentInfo(@RequestParam Integer maTB) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(maTB);
        return equipment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/usage/add")
    public String addUsage(@RequestBody Usage usage) {
        usage.setBorrowingTime(new Timestamp(System.currentTimeMillis()));
        try {
            usageService.createUsage(usage);
            return "/admin/equipment/loanEquipment";
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Thêm thất bại: " + e.getMessage()).toString();
        }
    }

    @PostMapping("/addMulti")
    public String addMultiUsage(@ModelAttribute UsageList usageList) {
        try {
            List<Usage> usages = usageList.getUsages();
            for (Usage usage : usages) {
                System.out.println("Processing Usage: {}"+ usage);
            }
            usageService.createMultiUsage(usages);
            return "/admin/equipment/excelImport";
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Thêm thất bại: " + e.getMessage()).toString();
        }
    }

    @PutMapping("/usage/edit")
    public ResponseEntity<Usage> updateUsage(Integer maTT, @RequestBody Usage usage) {
        Optional<Usage> existingUsage = usageService.getUsageById(maTT);
        if (existingUsage.isPresent()) {
            usage.setUsageId(maTT);
            return new ResponseEntity<>(usageService.updateUsage(usage), HttpStatus.OK);
        } else {
            ;
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/usage/delete")
    public ResponseEntity<?> deleteUsage(@RequestParam Integer id) {
        try {
            usageService.deleteUsage(id);
            return ResponseEntity.ok().body("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Xóa thất bại: " + e.getMessage());
        }
    }
}
