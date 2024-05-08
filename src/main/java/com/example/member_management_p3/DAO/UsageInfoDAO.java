package com.example.member_management_p3.DAO;

import com.example.member_management_p3.Model.Entity.UsageInfo;
import com.example.member_management_p3.Responsitory.UsageInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsageInfoDAO {
    @Autowired
    UsageInfoRespository usageInfoRespository;

    public boolean addUsageInfo(UsageInfo usageInfo) {
        if (usageInfoRespository.existsById(usageInfo.getMaTT())) {
            return false;
        }
        usageInfoRespository.save(usageInfo);
        return true;
    }
}
