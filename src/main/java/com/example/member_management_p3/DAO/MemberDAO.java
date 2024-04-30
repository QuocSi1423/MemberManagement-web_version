package com.example.member_management_p3.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.member_management_p3.Repository.MemberRepository;
import com.example.member_management_p3.Model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class MemberDAO {
    
    MemberRepository memberRepository = (MemberRepository)new Object();

    @PersistenceContext
    private EntityManager entityManager;


    public boolean addMember(Member member) {
        try {
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
            return false;
        }
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty())
			return null;
        return member.get();
    }

    public boolean deleteMember(Long id) {
        try {
            memberRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 

    @Transactional
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        try {
            String query = "DELETE FROM Member m WHERE m.khoa = :khoa OR m.nganh = :nganh OR SUBSTRING(m.maTV, 3, 2) = :maTVSubstring";
            entityManager.createQuery(query)
                .setParameter("khoa", khoa)
                .setParameter("nganh", nganh)
                .setParameter("maTVSubstring", maTVSubstring)
                .executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}