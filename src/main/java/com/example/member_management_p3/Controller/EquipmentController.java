package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Entity.Booking;
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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/bookEquipment")
    public String bookEquipment(Model model, @RequestParam("userId") String userId,
                                @RequestParam("equipmentId") String equipmentId,
                                @RequestParam("bookingTime") LocalDateTime bookingTime) {
        String success = "Thiết bị đã được mượn thành công";
        String err = "Thiết bị đã được mượn thất bại";
        LocalDateTime now = LocalDateTime.now();
        if (equipmentService.bookingEquipment(Integer.parseInt(equipmentId), now)){
            UsageInfo usageInfo = new UsageInfo();
            usageInfo.setMaTV(Integer.parseInt(userId));
            usageInfo.setMaTB(Integer.parseInt(equipmentId));
            usageInfo.setTgdatcho(bookingTime);
            usageInfo.setTgmuon(now);
            String response = usageInfoService.addUsageInfo(usageInfo);
            System.out.println(response);
            model.addAttribute("success", success);
            model.addAttribute("response", response);
            return "user/equipment/equipment";
        }
        model.addAttribute("err", err);
        return "user/equipment/equipment";
    }


    @PostMapping("/viewDeitailEquipmen")
    public String viewEquipmentDetails(@RequestParam("MaTB") int maTB, Model model) {
        LocalDateTime today = LocalDateTime.now();
        List<Booking> bookings = equipmentService.getBookingsForEquipmentFromDate(maTB, today);
        String success = "Thiết bị đã được mượn";
        String err = "Thiết bị chưa được mượn";
        if (bookings.isEmpty()) {
            model.addAttribute("err", err);
        }
        // Đưa thông tin vào model để trả về cho view
        model.addAttribute("success", success);
        model.addAttribute("bookings", bookings);

        // Trả về tên của view để hiển thị thông tin
        return "user/equipment/equipment-detail";
    }
}