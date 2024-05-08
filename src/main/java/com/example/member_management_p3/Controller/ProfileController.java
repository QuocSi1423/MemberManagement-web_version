package com.example.member_management_p3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

  @Autowired
  MemberService memberService;

  @GetMapping("/profile")
  public String GetData(Model model, HttpServletRequest request) {
    model.addAttribute("content", "/user/member/profile");
    HttpSession session = request.getSession();
    String matv = (String) session.getAttribute("matv");
    Member member = memberService.getMemberById(Long.parseLong(matv));
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
