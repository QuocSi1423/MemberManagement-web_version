package com.example.member_management_p3.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.Global;
import com.example.member_management_p3.model.SimpleMember;
import com.example.member_management_p3.model.Violation;
import com.example.member_management_p3.service.ViolationService;

@Controller
@RequestMapping("/admin/violations")
public class ViolationController {

    @Autowired
    private final ViolationService violationService;

    public ViolationController(ViolationService ViolationService) {
        this.violationService = ViolationService;
    }

    
    @GetMapping
    public String showViolationPage(@RequestParam(value = "filter", required = false) String filter, Model model) {
        Integer status = null;
        Date startDate = null;
        Date endDate = null;
        
        // filter 
        if (filter == null || filter.equals("all")) {
        } else if (filter.equals("processed")) {
            status = Global.PROCESSED;
        } else if (filter.equals("unprocessed")) {
            status = Global.UNPROCESSED;
        }
       
        // duration
        // .. 

        // load data
        List<Violation> violations;
        violations = violationService.getViolationListByFilter(status, startDate, endDate);

        // Gửi danh sách vi phạm đến trang HTML để hiển thị
        model.addAttribute("violations", violations);
        model.addAttribute("all", filter == null || filter.equals("none"));
        model.addAttribute("processed", filter != null && filter.equals("processed"));
        model.addAttribute("unprocessed", filter != null && filter.equals("unprocessed"));

        return "admin/violation/violation";
    }

    @GetMapping("/{id}")
    public String showDetailViolationPage(@PathVariable Integer id, Model model) {
        Violation violation;
        violation = violationService.getViolation(id);
        
        model.addAttribute("violation", violation);

        return "admin/violation/violation-detail";
    }

    @GetMapping("/new")
    public String showEmptyDetailViolationPage(Model model) {
        Violation violation = new Violation();
        violation.setMember(new SimpleMember());
        
        model.addAttribute("violation", violation);

        return "admin/violation/violation-detail";
    }

    @PostMapping("/new")
    public String addViolation(@RequestParam("memberId") Integer memberId,
            @RequestParam("handlingType") String handlingType,
            @RequestParam("fine") Integer fine,
            @RequestParam("status") String status,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Violation violation = new Violation();
        violation.setMemberId(memberId);
        violation.setDate(date);
        violation.setFine(fine);
        violation.setStatus(status.equals("on")? 1 : 0);
        violation.setHandlingType(handlingType);
        if (violationService.insertViolation(violation) == Global.SUCCESSFUL)
            return "redirect:/admin/violations";
        else
            return "redirect:/admin/violations/new";
    }
}