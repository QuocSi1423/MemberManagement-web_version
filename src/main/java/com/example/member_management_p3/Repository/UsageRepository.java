package com.example.member_management_p3.Repository;

import com.example.member_management_p3.Model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Integer> {
}