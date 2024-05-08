package com.example.member_management_p3.Model.Entity;

import java.time.LocalDateTime;

public class Booking {
    private String Hoten;
    private String TenTB;
    private LocalDateTime tgmuon;
    private LocalDateTime tgdatcho;

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getMaTB() {
        return TenTB;
    }

    public void setMaTB(String maTB) {
        this.TenTB = maTB;
    }

    public LocalDateTime getTgmuon() {
        return tgmuon;
    }

    public void setTgmuon(LocalDateTime tgmuon) {
        this.tgmuon = tgmuon;
    }

    public LocalDateTime getTgdatcho() {
        return tgdatcho;
    }

    public void setTgdatcho(LocalDateTime tgtral) {
        this.tgdatcho = tgtral;
    }
}
