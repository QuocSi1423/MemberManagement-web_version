package com.example.member_management_p3.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member_management_p3.Global;
import com.example.member_management_p3.model.Violation;
import com.example.member_management_p3.repository.ViolationRepository;

@Service
public class ViolationService {
    @Autowired
    private ViolationRepository dbSet;

    public int insertViolation(Violation violation) {
        try {
            if (!dbSet.existsById(violation.getViolationId())) {
                dbSet.save(violation);
                return Global.SUCCESSFUL;
            } 
            else {
                return Global.EXISTED;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }

    public int deleteViolation(Integer id) {
        try {
            if (dbSet.existsById(id)) {
                dbSet.deleteById(id);
                return Global.SUCCESSFUL;
            } 
            else {
                return Global.NOT_FOUND;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }

    public int changeStatus(Violation violation) {
        try {
            Optional<Violation> result = dbSet.findById(violation.getViolationId());
            if (result.isPresent()) {
                Violation current = result.get();
                current.setStatus(violation.getStatus());
                dbSet.save(current);
                return Global.SUCCESSFUL;
            } 
            else {
                return Global.NOT_FOUND;
            }
        } catch (Exception e) {
            return e.hashCode();
        }
    }
    
    public Violation getViolation(Integer id) {
        try {
            Optional<Violation> result = dbSet.findById(id);
            if (result.isPresent()) { return result.get(); } 
        } catch (Exception e) {}

        return null;
    }

    public List<Violation> getViolationListByFilter(Integer status, Date startDate, Date endDate) {
        try {
            return dbSet.getViolationListByFilter(status, startDate, endDate);
        } catch (Exception e) {}

        return null;
    }
}
