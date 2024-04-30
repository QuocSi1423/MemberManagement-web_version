package com.example.member_management_p3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member_management_p3.Model.Member;   
import com.example.member_management_p3.Model.ResponseStructure;
import com.example.member_management_p3.Service.MemberService;

@RestController
public class MemberAdminController {

    @Autowired
    MemberService service;

    @GetMapping("/get_all_members")
    public ResponseStructure getAllMembers() {
        System.out.println("Get all members");
        return service.getAllMembers();
    }

    @GetMapping("/test_blabla")
    public String test() {
        return "Test successful";
    }
    
}
