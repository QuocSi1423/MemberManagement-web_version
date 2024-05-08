package com.example.member_management_p3.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.member_management_p3.DAO.MemberDAO;
import com.example.member_management_p3.Model.Member;
import com.example.member_management_p3.Model.ResponseStructure;

@Service
public class MemberService {
    
    @Autowired
    private MemberDAO memberDao;

    public MemberService(MemberDAO memberDao) {
        this.memberDao = memberDao;
    }

    public String addMember(Member member) {
        if (memberDao.addMember(member))
            return "add member successfully";
        return "fail to add member";
    }

    public String addMultipleMembers(List<Member> members) {
        String result = memberDao.addMultipleMembers(members);
        if (result.equals("")) 
            return "add members successfully";
        return "fail to add members with id: " + result;
    }

    public String addMembersFromFile(MultipartFile file) {
        String result = memberDao.addMembersFromFile(file);
        if (result.equals("")) 
            return "add members successfully";
        return "fail to add members with id: " + result;
    }

    public String updateMember(Member member) {
        if (memberDao.updateMember(member))
            return "update member successfully";
        return "fail to update member";
    }

    public ResponseStructure<Member> updateMaTV(Long oldMaTV, Long newMaTV) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        if (memberDao.updateMaTV(oldMaTV, newMaTV)) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("update member's matv successfully");
            response.setData(null);
        } else {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("fail to update member's matv");
            response.setData(null);
        }
        return response;
    }

    public List<Member> getAllMembers() {
        List<Member> members = memberDao.getAllMembers();
        return members;
    }

    public Member getMemberById(long memberId) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        Member member = memberDao.getMemberById(memberId);
        return member;
    }

    public List<Member> getMembersByName(String hoTen) {
        List<Member> members = memberDao.getMembersByName(hoTen);
        return members;
    }

    public String deleteMember(long memberId) {
        if (memberDao.deleteMember(memberId)) 
            return "delete member successfully";
        return "fail to delete member";
    }

    public String deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        if (memberDao.deleteMembersByConditions(khoa, nganh, maTVSubstring))
            return "delete members successfully";
        return "fail to delete members";
    }
}