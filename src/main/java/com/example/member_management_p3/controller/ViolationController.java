package com.example.member_management_p3.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.Global;
import com.example.member_management_p3.model.Violation;
import com.example.member_management_p3.service.ViolationService;

@Controller
public class ViolationController {

    @Autowired
    private final ViolationService violationService;

    public ViolationController(ViolationService ViolationService) {
        this.violationService = ViolationService;
    }

    
    @GetMapping("/admin/violations")
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

    // @GetMapping("/admin/member/get_all_members")
    // public String getAllMembers(Model model) {
    //     System.out.println("Get all members");
    //     ResponseStructure<List<Member>> response = service.getAllMembers();
    //     model.addAttribute("response", response);
    //     return "getAllMembers";
    // }

    // @GetMapping("/admin/member/get_member/{id}")
    // public String getMember(@PathVariable Long id, Model model) {
    //     System.out.println("Get member by id");
    //     ResponseStructure<Member> response = service.getMemberById(id);
    //     model.addAttribute("response", response);
    //     return "getMember";
    // }

    // @GetMapping("/admin/member/get_members_by_name/{name}")
    // public String getMembersByName(@PathVariable String name, Model model) {
    //     System.out.println("Get members by name");
    //     ResponseStructure<List<Member>> response = service.getMembersByName(name);
    //     model.addAttribute("response", response);
    //     return "getMembersByName";
    // }

    // @PostMapping("/admin/member/add_member")
    // public String addMember(@RequestBody Member member, Model model) {
    //     System.out.println("Add member");
    //     ResponseStructure<Member> response = service.addMember(member);
    //     model.addAttribute("response", response);
    //     return "addMember";
    // }

    // @PostMapping("/admin/member/add_multiple_members")
    // public String addMultipleMembers(@RequestBody List<Member> members, Model model) {
    //     System.out.println("Add multiple members");
    //     ResponseStructure<Member> response = service.addMultipleMembers(members);
    //     model.addAttribute("response", response);
    //     return "addMultipleMembers";
    // }

    // @PutMapping("/admin/member/update_member")
    // public String updateMember(@RequestBody Member member, Model model) {
    //     System.out.println("Update member");
    //     ResponseStructure<Member> response = service.updateMember(member);
    //     model.addAttribute("response", response);
    //     return "updateMember";
    // }

    // @DeleteMapping("/admin/member/delete_member/{id}")
    // public String deleteMember(@PathVariable Long id, Model model) {
    //     System.out.println("Delete member");
    //     ResponseStructure<Member> response = service.deleteMember(id);
    //     model.addAttribute("response", response);
    //     return "deleteMember";
    // }

    // @PostMapping("/admin/member/delete_members_by_conditions")
    // public String deleteMembersByConditions(@RequestBody MemberDeleteCondition conditions, Model model) {
    //     System.out.println("Delete members by conditions");
    //     System.out.println(conditions.toString());
    //     ResponseStructure<Member> response = service.deleteMembersByConditions(conditions.getKhoa(), conditions.getNganh(), conditions.getMaTVSubstring());
    //     model.addAttribute("response", response);
    //     return "deleteMembersByConditions";
    // } 

    // @PostMapping("/admin/add_members/submit_file")
    // public String submitFile(@RequestParam("file") MultipartFile file, Model model) {
    //     ResponseStructure<Member> response = service.addMembersFromFile(file);
    //     model.addAttribute("response", response);
    //     return "submitFile";
    // }
}