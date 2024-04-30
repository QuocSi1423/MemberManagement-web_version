package com.example.member_management_p3.Service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    public ResponseStructure<Member> addMember(Member member) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        if (memberDao.addMember(member)) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("add member successfully");
            response.setData(null);
        } else {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("fail to add member");
            response.setData(null);
        }
        return response;
    }

    public ResponseStructure<Member> addMultipleMembers(List<Member> members) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        String result = memberDao.addMultipleMembers(members);
        if (result.equals("")) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("add members successfully");
            response.setData(null);
        } else {
            response.setMessage("fail to add members with id: " + result);
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(null);

        }
        return response;
    }

    public ResponseStructure<Member> updateMember(Member member) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        if (memberDao.updateMember(member)) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("update member successfully");
            response.setData(null);
        } else {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("fail to member");
            response.setData(null);
        }
        return response;
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

    public ResponseStructure<List<Member>> getAllMembers() {
        ResponseStructure<List<Member>> response = new ResponseStructure<List<Member>>();
        List<Member> members = memberDao.getAllMembers();
        if (members.size() > 0) {
            response.setMessage("get list of members successfully");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(members);
        } else {
            response.setMessage("no member found");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(null);
        }
        return response;
    }

    public ResponseStructure<Member> getMemberById(long memberId) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        Member member = memberDao.getMemberById(memberId);
        // return member;
        if (member != null) {
            // return member;
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("Found");
            response.setData(member);
            return response;
        } 
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("not found");
        response.setData(member);
        return response;
    }

    public ResponseStructure<List<Member>> getMembersByName(String hoTen) {
        ResponseStructure<List<Member>> response = new ResponseStructure<List<Member>>();
        List<Member> members = memberDao.getMembersByName(hoTen);
        if (members.size() > 0) {
            response.setMessage("get list of members successfully");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(members);
        } else {
            response.setMessage("no member found");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(null);
        }
        return response;
    }

    public ResponseStructure<Member> deleteMember(long memberId) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        if (memberDao.deleteMember(memberId)) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("delete member successfully");
            response.setData(null);
        } else {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("fail to delete member");
            response.setData(null);
        }
        return response;
    }

    public ResponseStructure<Member> deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        ResponseStructure<Member> response = new ResponseStructure<Member>();
        if (memberDao.deleteMembersByConditions(khoa, nganh, maTVSubstring)) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("delete members successfully");
            response.setData(null);
        } else {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("fail to delete members");
            response.setData(null);
        }
        return response;
    }
}