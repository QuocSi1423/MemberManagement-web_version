package com.example.member_management_p3.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "thietbi")
public class Equipment {
    @Id
    @Column(name = "MaTB")
    private Integer maTB;


    @Column(name = "TenTB")
    private String tenTB;

    @Column(name = "MotaTB")
    private String moTaTB;

    @Column(name="mo_tatb")
    private String mo_tatb;

    public Equipment() {
    }

    public Equipment(Integer maTB, String tenTB, String moTaTB, String mo_tatb) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.moTaTB = moTaTB;
        this.mo_tatb = mo_tatb;
    }

    public Integer getMaTB() {
        return maTB;
    }

    public void setMaTB(Integer maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMoTaTB() {
        return moTaTB;
    }

    public void setMoTaTB(String moTaTB) {
        this.moTaTB = moTaTB;
    }

    public String getMo_tatb() {
        return mo_tatb;
    }

    public void setMo_tatb(String mo_tatb) {
        this.mo_tatb = mo_tatb;
    }
}