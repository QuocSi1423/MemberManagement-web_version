package com.example.member_management_p3.Controller;

import com.example.member_management_p3.Model.Usage;
import com.example.member_management_p3.Service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CheckinController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/checkin")
    public String showInfoPage(Model model) {
        List<Usage> usages = infoService.getAllUsages();
        model.addAttribute("usages", usages);
        return "admin/equipment/checkin";
    }
}
