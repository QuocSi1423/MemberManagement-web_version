package com.example.member_management_p3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member_management_p3.service.EmailService;

@Controller
public class ForgotPassword {

    @Autowired
    private final EmailService emailService;

    public ForgotPassword(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/forgot_password")
    public String fotgotPassword() {
        return "user/member/forgotpassword";
    }

    @PostMapping("/forgotPassword")
    public String sendPassword(@RequestParam("MaTV") String matv) {
        String email = "ntlilly1006@gmail.com";
        String subject = "Forgot Password";
        String pwd = "gia su day la password";

        if (emailService.send(email, subject, pwd) != null) {
            return "redirect:/login";
        } else {
            return "user/member/forgotpassword";
        }
    }

}