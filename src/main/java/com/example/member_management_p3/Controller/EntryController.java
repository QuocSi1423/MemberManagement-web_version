package com.example.member_management_p3.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.service.MemberService;

@Controller
public class EntryController {
    @Autowired
    MemberService memberService;

    @PostMapping("/entry")
    public String Login(Model model, @RequestParam("MaTV") String matv) {
        System.out.println(matv);
        Long MaTV = Long.parseLong(matv);
        Member member = memberService.getMemberById(MaTV);
        if(member != null) {
            model.addAttribute("member", member);
        } else {
            Member member2 = new Member();
            model.addAttribute("member", member2);
            model.addAttribute("error", "Không tồn tại thành viên này!");
        }
        model.addAttribute("content", "/admin/entry");
        return "/admin/admin";
    }

    @GetMapping("/entry")
    public String GetData(Model model) {
        model.addAttribute("content", "/admin/entry");

        return "admin/admin";
    }
}
