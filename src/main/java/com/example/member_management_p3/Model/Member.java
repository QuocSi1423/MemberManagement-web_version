package com.example.member_management_p3.Model;

import jakarta.persistence.*;
import org.json.JSONObject;

@Entity
@Table(name = "thanhvien")
public class Member {
    @Id
    @Column(name = "MaTV")
    private long maTV;

    @Column(name = "Hoten")
    private String hoTen;

    @Column(name = "Khoa")
    private String khoa;

    @Column(name = "Nganh")
    private String nganh;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "SDT")
    private String sdt;

    public Member() {
        // Constructor for non-info object
    }

    public Member(long maTV, String hoTen, String khoa, String nganh, String password, String email, String sdt) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.password = password;
        this.email = email;
        this.sdt = sdt;
    }

    // Getter and Setter for all attributes

    public long getMaTV() {
        return maTV;
    }

    public void setMaTV(long maTV) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "Members{" +
                "maTV=" + maTV +
                ", hoTen='" + hoTen + '\'' +
                ", khoa='" + khoa + '\'' +
                ", nganh='" + nganh + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maTV", maTV);
        jsonObject.put("hoTen", hoTen);
        jsonObject.put("khoa", khoa);
        jsonObject.put("nganh", nganh);
        jsonObject.put("password", password);
        jsonObject.put("email", email);
        jsonObject.put("sdt", sdt);
        return jsonObject;
    }
}