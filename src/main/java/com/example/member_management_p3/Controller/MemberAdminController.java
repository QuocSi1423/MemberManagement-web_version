package com.example.member_management_p3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Model.MemberDeleteCondition;
import com.example.member_management_p3.Model.ResponseStructure;
import com.example.member_management_p3.Service.MemberService;

@Controller
public class MemberAdminController {

    @Autowired
    MemberService service;

    @GetMapping("/admin/member/test")
    public String test() {
        return "admin/member/test";
    }

    @GetMapping("/admin/member/get_all_members")
    public String getAllMembers(Model model) {
        List<Member> members = service.getAllMembers();
        // System.out.print(members);
        model.addAttribute("members", members);
        return "admin/member/members";
    }

    // @GetMapping("/admin/member/get_member/{id}")
    // public String getMember(@PathVariable Long id, Model model) {
    //     System.out.println("Get member by id");
    //     ResponseStructure<Member> response = service.getMemberById(id);
    //     model.addAttribute("response", response);
    //     return "getMember";
    // }

    @GetMapping("/admin/member/get_members_by_name/{name}")
    public String getMembersByName(@PathVariable String name, Model model) {
        System.out.println("Get members by name");
        List<Member> members = service.getMembersByName(name);
        model.addAttribute("members", members);
        return "admin/member/members";
    }

    @GetMapping("/admin/member/single_member_adding_form")
    public String addMemberForm(Model model) {
        return "/admin/member/single_mem_adding_form";
    }

    @PostMapping("/admin/member/add_member")
    public String addMember(@ModelAttribute Member member, Model model) {
        System.out.println("Add member");
        // member.setPassword("1234567Th");
        // System.out.println(member.toString());]
        String response = service.addMember(member);
        // System.out.println(response);
        model.addAttribute("response", response);
        return "/admin/member/result";
    }

    @GetMapping("/admin/member/adding_members_from_file")
    public String addMembersFromFileForm(Model model) {
        return "/admin/member/adding_members_from_file";
    }

    @PostMapping("/admin/add_members/submit_file")
    public String submitFile(@RequestParam("file") MultipartFile file, Model model) {
        System.out.println("Add members from file");
        String response = service.addMembersFromFile(file);
        System.out.println(response);
        model.addAttribute("response", response);
        return "/admin/member/result";
    }

    @GetMapping("/admin/member/update_member_form/{id}")
    public String updateMemberForm(@PathVariable Long id, Model model) {
        Member member = service.getMemberById(id);
        model.addAttribute("member", member);
        return "/admin/member/updating_member_form";
    }

    @PostMapping("/admin/member/update_member")
    public String updateMember(@ModelAttribute Member member, Model model) {
        System.out.println("Update member");
        System.out.println(member.toString());
        String response = service.updateMember(member);
        System.out.println(response);
        model.addAttribute("response", response);
        return "/admin/member/result";
    }

    @GetMapping("/admin/member/delete_member/{id}")
    public String deleteMember(@PathVariable Long id, Model model) {
        System.out.println("Delete member");
        String response = service.deleteMember(id);
        model.addAttribute("response", response);
        return "/admin/member/result";
    }

    @GetMapping("/admin/member/deleting_members_by_conditions_form")
    public String deleteMembersByConditionsForm(Model model) {
        return "/admin/member/deleting_members_by_conditions_form";
    }

    @PostMapping("/admin/member/delete_members_by_conditions")
    public String deleteMembersByConditions(@ModelAttribute MemberDeleteCondition conditions, Model model) {
        System.out.println("Delete members by conditions");
        // System.out.println(conditions.toString());
        String response = service.deleteMembersByConditions(conditions.getKhoa(), conditions.getNganh(), conditions.getMaTVSubstring());
        // String response = "successfully";
        model.addAttribute("response", response);
        return "/admin/member/result";
    } 

    // @PostMapping("/admin/member/add_multiple_members")
    // public String addMultipleMembers(@RequestBody List<Member> members, Model model) {
    //     System.out.println("Add multiple members");
    //     ResponseStructure<Member> response = service.addMultipleMembers(members);
    //     model.addAttribute("response", response);
    //     return "addMultipleMembers";
    // }

}