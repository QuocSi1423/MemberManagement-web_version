package com.example.member_management_p3.Model.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "thongtinsd")
public class UsageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaTT;
    private int MaTV;
    private int MaTB;
    private LocalDateTime tgvao;
    private LocalDateTime tgmuon;
    private LocalDateTime tgtra;
    private LocalDateTime tgdatcho;

    public long getMaTT() {
        return MaTT;
    }

    public void setMaTT(int MaTT) {
        this.MaTT = MaTT;
    }

    public int getMaTV() {
        return MaTV;
    }

    public void setMaTV(int MaTV) {
        this.MaTV = MaTV;
    }

    public int getMaTB() {
        return MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public LocalDateTime getTgvao() {
        return tgvao;
    }

    public void setTgvao(LocalDateTime tgvao) {
        this.tgvao = tgvao;
    }

    public LocalDateTime getTgmuon() {
        return tgmuon;
    }

    public void setTgmuon(LocalDateTime tgmuon) {
        this.tgmuon = tgmuon;
    }

    public void setTgtra(LocalDateTime tgtra) {
        this.tgtra = tgtra;
    }

    public LocalDateTime getTgdatcho() {
        return tgdatcho;
    }

    public void setTgdatcho(LocalDateTime tgdatcho) {
        this.tgdatcho = tgdatcho;
    }
}
