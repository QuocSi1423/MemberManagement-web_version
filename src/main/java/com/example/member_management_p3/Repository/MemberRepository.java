package com.example.member_management_p3.Repository;

import com.example.member_management_p3.Model.Member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.member_management_p3.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE m.hoTen LIKE %:hoTen%")
    List<Member> findByName(@Param("hoTen") String hoTen);
}