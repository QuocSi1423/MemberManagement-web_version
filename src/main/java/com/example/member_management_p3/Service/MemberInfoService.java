package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Repository.MemberInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberInfoService {
    @Autowired
    private MemberInfoRepository memberInfoRepository;
    public Optional<Member> getMemberById(Integer maTV) {
        return memberInfoRepository.findById(maTV);
    }
}
