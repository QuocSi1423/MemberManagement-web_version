package com.example.member_management_p3.Controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.service.MemberService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Controller
public class ForgotPassword {

  @Autowired
  MemberService memberService;

  @Autowired
  private JavaMailSender javaMailSender;

  @GetMapping("/forgot_password")
  public String GetForgotPassword() {

    return "/user/member/forgot-password";
  }

  @PostMapping("/forgot-password")
  public String SendMail(Model model, @RequestParam("MaTV") String matv) {

    Long mtv = Long.parseLong(matv);
    Member member = memberService.getMemberById(mtv);
    if (member == null) {
      model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng");

    } else {
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(member.getEmail());
      mailMessage.setSubject("Forgot password");
      mailMessage.setText("Your password is " + member.getPassword());

      javaMailSender.send(mailMessage);
    }
    return "/user/member/login";
  }

}
