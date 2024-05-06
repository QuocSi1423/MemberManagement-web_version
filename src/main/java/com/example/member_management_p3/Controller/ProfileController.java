package com.example.member_management_p3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
  @GetMapping("/profile")
  public String GetData(Model model) {
    model.addAttribute("content", "/user/member/profile");
    return "user/index";
  }
}
