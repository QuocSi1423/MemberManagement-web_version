package com.example.member_management_p3.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "thongtinsd")
public class Usage {

    @Id
    @Column(name = "MaTT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usageId;

    @Column(name = "MaTV")
    private Integer memberId;

    @Column(name = "MaTB")
    private Integer equipmentId;

    @Column(name = "TGVao")
    private Timestamp entryTime = null;

    @Column(name = "TGMuon")
    private Timestamp borrowingTime;

    @Column(name = "TGTra")
    private Timestamp returnTime = null;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTV", referencedColumnName = "MaTV", insertable = false, updatable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTB", referencedColumnName = "MaTB", insertable = false, updatable = false)
    private Equipment equipment;

    public Usage() {
    }

    public Usage(Integer usageId) {
        this.usageId = usageId;
    }

    public Usage(Integer usageId, Integer memberId, Integer equipmentId, Timestamp entryTime, Timestamp borrowingTime,
                 Timestamp returnTime) {
        this.usageId = usageId;
        this.memberId = memberId;
        this.equipmentId = equipmentId;
        this.entryTime = entryTime;
        this.borrowingTime = borrowingTime;
        this.returnTime = returnTime;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Timestamp getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(Timestamp borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public Member getMember() {
        return member;
    }

    public Member getMemberByID(Integer id) {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}