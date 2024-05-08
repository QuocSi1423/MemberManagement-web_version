package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Entity.Member;
import com.example.member_management_p3.Responsitory.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRespository memberRespository;

    public List<Member> getAllMembers(){
        return memberRespository.findAll();
    }
}
