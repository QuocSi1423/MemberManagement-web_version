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

    public ResponseStructure addMember(Member member) {
        ResponseStructure response = new ResponseStructure();
        if (memberDao.addMember(member)) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure addMultipleMembers(List<Member> members) {
        ResponseStructure response = new ResponseStructure();
        String result = memberDao.addMultipleMembers(members);
        if (result.equals("")) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            // response.setData(members.get(0).toJson());
            response.setData(new JSONObject().put("error_member", result));

        }
        return response;
    }

    public ResponseStructure updateMember(Member member) {
        ResponseStructure response = new ResponseStructure();
        if (memberDao.updateMember(member)) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure updateMaTV(Long oldMaTV, Long newMaTV) {
        ResponseStructure response = new ResponseStructure();
        if (memberDao.updateMaTV(oldMaTV, newMaTV)) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure getAllMembers() {
        ResponseStructure response = new ResponseStructure();
        List<Member> members = memberDao.getAllMembers();
        if (members.size() > 0) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            JSONObject data = new JSONObject();
            for (Member member : members) {
                data.put(String.valueOf(member.getMaTV()), member.toJson());
            }
            response.setData(data);
        } else {
            response.setMessage("no member found");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure getMemberById(long memberId) {
        ResponseStructure response = new ResponseStructure();
        Member member = memberDao.getMemberById(memberId);
        if (member != null) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(member.toJson());
        } else {
            response.setMessage("member not found");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure deleteMember(long memberId) {
        ResponseStructure response = new ResponseStructure();
        if (memberDao.deleteMember(memberId)) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }

    public ResponseStructure deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        ResponseStructure response = new ResponseStructure();
        if (memberDao.deleteMembersByConditions(khoa, nganh, maTVSubstring)) {
            response.setMessage("success");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        } else {
            response.setMessage("fail");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setData(new JSONObject().put("", ""));
        }
        return response;
    }
}