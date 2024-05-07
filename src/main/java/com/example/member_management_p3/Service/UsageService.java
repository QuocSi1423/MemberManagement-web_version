package com.example.member_management_p3.Service;

import com.example.member_management_p3.Model.Usage;
import com.example.member_management_p3.Repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsageService {

    @Autowired
    private UsageRepository usageRepository;

    public List<Usage> getAllUsage() {
        return usageRepository.findAll();
    }

    public Optional<Usage> getUsageById(Integer maTT) {
        return usageRepository.findById(maTT);
    }

    public void createUsage(Usage usage) {
        usageRepository.save(usage);
    }

    public void createMultiUsage(List<Usage> usages) {
        usages.removeIf(usage -> usage.getUsageId() == null);
        usageRepository.saveAll(usages);
    }

    public Usage updateUsage(Usage usage) {
        return usageRepository.save(usage);
    }

    public void deleteUsage(Integer maTT) {
        usageRepository.deleteById(maTT);
    }
}