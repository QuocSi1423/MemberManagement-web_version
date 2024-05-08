package com.example.member_management_p3.Controller.UsageInfo;

import com.example.member_management_p3.Model.Entity.UsageInfo;
import com.example.member_management_p3.Service.UsageInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsageInfoController {
    private UsageInfoService usageInfoService;

    @GetMapping("/user/equipment")
    public String getUsageInfoByMemberId(Model model){
        List<UsageInfo> usageInfoList = usageInfoService.getAllUsageInfo();
        model.addAttribute("usageInfoList", usageInfoList);
        return "user/equipment";
    }
}