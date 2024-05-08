package com.example.member_management_p3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

  @Autowired
  MemberService memberService;

  @GetMapping("/login")
  public String GetData(Model model) {
    return "user/member/login";
  }

  @PostMapping("/login")
  public String Login(Model model, @RequestParam("MaTV") String matv, @RequestParam("MatKhau") String matkhau, HttpServletRequest request) {
    Long mtv = Long.parseLong(matv);
    Member member = memberService.getMemberById(mtv);
    if (member == null || !matkhau.equals(member.getPassword())) {
      model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
      return "user/member/login";
    } else {
      HttpSession session = request.getSession();
      session.setAttribute("matv", matv);

      return "redirect:/profile";
    }
  }
}
