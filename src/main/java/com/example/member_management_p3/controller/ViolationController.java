package com.example.member_management_p3.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    List<Violation> violations;


    public ViolationController(ViolationService violationService) {
        this.violationService = violationService;
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
    public String addViolation(@RequestParam("memberId") Long memberId,
            @RequestParam("handlingType") String handlingType,
            @RequestParam("fine") Integer fine,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Violation violation = new Violation();
        violation.setMember(new SimpleMember(memberId, null));
        violation.setDate(date);
        violation.setFine(fine);
        violation.setStatus(String.valueOf(status).equals("on")? 1 : 0);
        violation.setHandlingType(handlingType);
        if (violationService.insertViolation(violation) == Global.SUCCESSFUL)
            return "redirect:/admin/violations";
        else
        // hien dialog thong bao them that bai
            return "redirect:/admin/violations/new";
    }

    @PostMapping("/save")
    public String updateViolation(@RequestParam("violationId") Integer violationId, 
                @RequestParam(value = "status", required = false) String status, Model model) {

        System.out.print(violationId);

        Violation violation = new Violation();
        violation.setViolationId(violationId);
        violation.setStatus(String.valueOf(status).equals("on")? 1 : 0);
    
        if (violationService.changeStatus(violation) == Global.SUCCESSFUL)        
            model.addAttribute("message", "Lưu thành công!");
        else
            model.addAttribute("message", "Đã có lỗi xảy ra!");
        
        return "redirect:/admin/violations";
    }

    @DeleteMapping()
    public String deleteViolation(@RequestParam("violationId") Integer violationId, Model model) {
        if (violationService.deleteViolation(violationId) == Global.SUCCESSFUL)
            model.addAttribute("message", "Xoá thành công!");
        else
            model.addAttribute("message", "Đã có lỗi xảy ra!");
        
        return "redirect:/admin/violations";
    }
}