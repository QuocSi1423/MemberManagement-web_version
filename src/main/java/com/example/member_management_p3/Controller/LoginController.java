package com.example.member_management_p3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String GetData(Model model) {
    return "user/member/login";
  }

  @PostMapping("/submitLogin")
  public String Login(Model model, @RequestParam("MaTV") String matv){
    System.out.println("MaTV: "+matv);
    model.addAttribute("matv", matv);
    return "redirect:/profile";
  }
}
