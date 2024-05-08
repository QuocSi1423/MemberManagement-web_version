package com.example.member_management_p3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Model.Member;
import com.example.member_management_p3.service.MemberService;

@Controller
public class ProfileController {

  @Autowired
  MemberService memberService;

  @GetMapping("/profile")
  public String GetData(Model model) {
    model.addAttribute("content", "/user/member/profile");
    Long MaTV = 1190308010l;
    Member member = memberService.getMemberById(MaTV);
    model.addAttribute("member", member);
    return "user/index";
  }

  @GetMapping("/reservation")
  public String GetTB(Model model) {


    model.addAttribute("content", "/user/equipment/equipment");
    model.addAttribute("hello", "hello");
    return "user/index";
  }
}
