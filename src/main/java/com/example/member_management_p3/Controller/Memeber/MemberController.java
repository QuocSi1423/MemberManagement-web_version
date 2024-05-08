package com.example.member_management_p3.Controller.Memeber;

import com.example.member_management_p3.Model.Entity.Member;
import com.example.member_management_p3.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    List<Member> getAllMembers(Model model){
        return memberService.getAllMembers();
    }

//    @GetMapping("index")
//    List<Member> getAllMembers(Model model){
//        List<Member> members = memberService.getAllMembers();
//        model.addAttribute("members", members);
//        return "index";
//    }
}
