package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Entity.UsageInfo;
import com.example.member_management_p3.Responsitory.UsageInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsageInfoService {
    @Autowired
    private UsageInfoRespository usageInfoRespository;

    public List<UsageInfo> getAllUsageInfo(){
        return usageInfoRespository.findAll();
    }
}