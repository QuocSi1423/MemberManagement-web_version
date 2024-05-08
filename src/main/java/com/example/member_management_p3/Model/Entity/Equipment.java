package com.example.member_management_p3.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "thietbi")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaTB;
    private String TenTB;
    private String MotaTB;

    public long getMaTB() {
        return MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public String getTenTB() {
        return TenTB;
    }

    public void setTenTB(String TenTB) {
        this.TenTB = TenTB;
    }

    public String getMotaTB() {
        return MotaTB;
    }

    public void setMotaTB(String MotaTB) {
        this.MotaTB = MotaTB;
    }
}
