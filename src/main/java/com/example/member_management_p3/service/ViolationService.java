package com.example.member_management_p3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member_management_p3.Global;
import com.example.member_management_p3.model.Violation;
import com.example.member_management_p3.repository.ViolationRepository;

@Service
public class ViolationService {

    private final ViolationRepository violationRepository;

    @Autowired
    public ViolationService(ViolationRepository violationRepository) {
        this.violationRepository = violationRepository;
    }

    public int insertViolation(Violation violation) {
        try {
            if (!violationRepository.existsById(violation.getViolationId())) {
                violationRepository.save(violation);
                return Global.SUCCESSFUL;
            } else {
                return Global.EXISTED;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }

    public int deleteViolation(Integer id) {
        try {
            if (violationRepository.existsById(id)) {
                violationRepository.deleteById(id);
                return Global.SUCCESSFUL;
            } else {
                return Global.NOT_FOUND;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }

    public int changeStatus(Violation violation) {
        try {
            Optional<Violation> result = violationRepository.findById(violation.getViolationId());
            if (result.isPresent()) {
                Violation current = result.get();
                current.setStatus(violation.getStatus());
                violationRepository.save(current);
                return Global.SUCCESSFUL;
            } else {
                return Global.NOT_FOUND;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }

    public Violation getViolation(Integer id) {
        try {
            Optional<Violation> result = violationRepository.findById(id);
            return result.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Violation> getViolationListByFilter(Integer status, Date startDate, Date endDate) {
        try {
            return violationRepository.getViolationListByFilter(status, startDate, endDate);
        } catch (Exception e) {
            return null;
        }
    }
}
