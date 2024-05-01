package com.example.member_management_p3.Controller;

import java.util.List;

import org.json.JSONObject;
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
import com.example.member_management_p3.Model.MemberDeleteCondition;
import com.example.member_management_p3.Model.ResponseStructure;
import com.example.member_management_p3.Service.MemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class RestMemberAdminController {

    @Autowired
    MemberService service;

    
    @GetMapping("/admin/member/get_all_members")
    public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers() {
        System.out.println("Get all members");
        ResponseStructure<List<Member>> response = service.getAllMembers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/admin/member/get_member/{id}")
    public ResponseEntity<ResponseStructure<Member>> getMember(@PathVariable Long id) {
        System.out.println("Get member by id");
        ResponseStructure<Member> response = service.getMemberById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
        // return service.getMemberById(id).toJson();
    }

    @GetMapping("/admin/member/get_members_by_name/{name}")
    public ResponseEntity<ResponseStructure<List<Member>>> getMembersByName(@PathVariable String name) {
        System.out.println("Get members by name");
        ResponseStructure<List<Member>> response = service.getMembersByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
      sample input:
     {
        "maTV": 111111111,
        "hoTen": "test",
        "khoa": "test123",
        "nganh": "test123",
        "password": "123456789",
        "email": "blabla@gmail.com",
        "sdt": 56721334
    }
    
    Sample output:
    Success:
    {
        "statusCode": 201,
        "message": "add member successfully",
        "data": null
    }
    Fail
    {
        "statusCode": 201,
        "message": "fail to add member",
        "data": null
    }
     */
    @PostMapping("/admin/member/add_member")
    public ResponseEntity<ResponseStructure<Member>> addMember(@RequestBody Member member) {
        System.out.println("Add member");
        ResponseStructure<Member> response = service.addMember(member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /*
    sample input:
    [
        {
            "maTV": 111111114,
            "hoTen": "test",
            "khoa": "test123",
            "nganh": "test123",
            "password": "123456789",
            "email": "blabla@gm2ail.com",
            "sdt": 56721334
        },
        {
            "maTV": 111111113,
            "hoTen": "test",
            "khoa": "test123",
            "nganh": "test123",
            "password": "123456789",
            "email": "blabla@gm2ail.com",
            "sdt": 56721334
        }
    ]

    Sample output:
    Success:
    {
        "statusCode": 201,
        "message": "add members successfully",
        "data": null
    }
    Fail:
    {
        "statusCode": 201,
        "message": "fail to add members with id: 111111113",
        "data": null
    }
     */
    @PostMapping("/admin/member/add_multiple_members")
    public ResponseEntity<ResponseStructure<Member>> addMultipleMembers(@RequestBody List<Member> members) {
        System.out.println("Add multiple members");
        ResponseStructure<Member> response = service.addMultipleMembers(members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
    Sample input:
    {
        "maTV": 111111111,
        "hoTen": "test update",
        "khoa": "test123",
        "nganh": "test123",
        "password": "123456789",
        "email": "
    }

    Sample output:
    Success:
    {
        "statusCode": 201,
        "message": "update member successfully",
        "data": null
    }
    Fail:
    {
        "statusCode": 201,
        "message": "fail to member",
        "data": null
    }
     */
    @PutMapping("/admin/member/update_member")
    public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member) {
        System.out.println("Update member");
        ResponseStructure<Member> response = service.updateMember(member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    

    @DeleteMapping("/admin/member/delete_member/{id}")
    public ResponseEntity<ResponseStructure<Member>> deleteMember(@PathVariable Long id) {
        System.out.println("Delete member");
        ResponseStructure<Member> response = service.deleteMember(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/admin/member/delete_members_by_conditions")
    public ResponseEntity<ResponseStructure<Member>> deleteMembersByConditions(@RequestBody MemberDeleteCondition conditions) {
        System.out.println("Delete members by conditions");
        System.out.println(conditions.toString());
        ResponseStructure<Member> response = service.deleteMembersByConditions(conditions.getKhoa(), conditions.getNganh(), conditions.getMaTVSubstring());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }  
}
