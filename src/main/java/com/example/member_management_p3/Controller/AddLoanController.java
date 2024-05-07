package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Equipment;
import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Model.Usage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class AddLoanController {
    @GetMapping("/loanTable")
    public String showLoanPage(Model model) {
        Usage usage = new Usage();
        Member member = new Member();
        Equipment equipment = new Equipment();
        model.addAttribute("usage",usage);
        model.addAttribute("member",member);
        model.addAttribute("equipment",equipment);
        return "admin/equipment/loanEquipment";
    }

    @GetMapping("/excelTable")
    public String showExcelPage(Model model) {
        Usage usage = new Usage();
        model.addAttribute("usage",usage);
        return "admin/equipment/excelImport";
    }
}
