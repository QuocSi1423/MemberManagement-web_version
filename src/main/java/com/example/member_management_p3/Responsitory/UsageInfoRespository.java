package com.example.member_management_p3.Responsitory;

import com.example.member_management_p3.Model.Entity.UsageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsageInfoRespository extends JpaRepository<UsageInfo, Long> {

}
