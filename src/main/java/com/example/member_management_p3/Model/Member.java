package com.example.member_management_p3.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "thanhvien")
public class Member {

    @Id
    @Column(name = "MaTV")
    private Integer maTV;

    @Column(name = "Hoten")
    private String hoTen;

    @Column(name = "Khoa")
    private String khoa;

    @Column(name = "Nganh")
    private String nganh;

    @Column(name = "SDT")
    private String sdt;

    public Member() {}

    public Member(Integer maTV, String hoTen, String khoa, String nganh, String sdt) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    public Member(String hoTen, String khoa, String nganh, String sdt) {
        // this.maTV = maTV; // This constructor can be used if maTV is auto-generated
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    // Getters and setters
    public Integer getMaTV() {
        return maTV;
    }

    public void setMaTV(Integer maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}