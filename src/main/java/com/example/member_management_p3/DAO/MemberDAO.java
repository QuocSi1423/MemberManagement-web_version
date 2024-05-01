package com.example.member_management_p3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.member_management_p3.Repository.MemberRepository;
import com.example.member_management_p3.Model.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Reader;

@Repository
public class MemberDAO {
    
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private EntityManager entityManager;


    public boolean addMember(Member member) {
        try {
            if (memberRepository.existsById(member.getMaTV()))
                return false;
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String addMultipleMembers(List<Member> members) {
        List<Long> addedMemberIds = new ArrayList<Long>(); // in case any issue happens, remove previous records;
        boolean flag = true;
        String result = "";
        for (Member mem : members) {
            if (!addMember(mem)) {
                flag = false;
                result = String.valueOf(mem.getMaTV());
                break;
            }
            addedMemberIds.add(mem.getMaTV());
        }
        if (flag == false && addedMemberIds.size() > 0) {
            for (Long id : addedMemberIds) {
                deleteMember(id);
            }
        }
        return result;
    }

    public String addMembersFromFile(MultipartFile file) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            
            List<Member> members = new ArrayList<>();
            for (CSVRecord record : records) {
                Member member = new Member();
                member.setMaTV(Long.parseLong(record.get("MaTV")));
                member.setHoTen(record.get("HoTen"));
                member.setKhoa(record.get("Khoa"));
                member.setNganh(record.get("Nganh"));
                member.setSdt(record.get("SDT"));
                member.setPassword(record.get("PassWord"));
                member.setEmail(record.get("Email"));
                members.add(member);
            }
            
            // Add the members to the database
            return addMultipleMembers(members);
        } catch (Exception e) {
            return "Failed to add members: " + e.getMessage();
        }
    } 

    public boolean updateMember(Member member) {
        try {
            if (memberRepository.existsById(member.getMaTV())) {
                memberRepository.save(member);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateMaTV(Long oldMaTV, Long newMaTV) {
        try {
            Optional<Member> memberOptional = memberRepository.findById(oldMaTV);
            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                member.setMaTV(newMaTV);
                memberRepository.save(member);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Member> getAllMembers() {
        List<Member> mems = memberRepository.findAll();
        for (Member mem:mems) {
            System.out.println(mem.toJson());
        }
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty())
			return null;
        return member.get();
    }

    public List<Member> getMembersByName(String name) {
        List<Member> mems = memberRepository.findByName(name);
        if (mems.isEmpty())
            return null;
        return mems;
    }

    public boolean deleteMember(Long id) {
        try {
            if (memberRepository.existsById(id)) {
                memberRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        try {
            String query = "DELETE FROM thanhvien WHERE";

            if (khoa != null && !khoa.isEmpty())
                query += " khoa = '" + khoa + "' and";  
            if (nganh != null && !nganh.isEmpty())
                query += " nganh = '" + nganh + "' and";
            if (maTVSubstring != null && !maTVSubstring.isEmpty())
                query += " SUBSTRING(maTV, 3, 2) = '" + maTVSubstring + "' and";

            // Remove trailing spaces and check if the query ends with "and"
            query = query.trim();
            if (query.endsWith("and")) {
                // Remove the last "and"
                query = query.substring(0, query.length() - 3);
            }

            entityManager.createNativeQuery(query).executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}