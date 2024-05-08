package com.example.member_management_p3.model;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "xuly")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXL")
    private Integer violationId;

    @Column(name = "MaTV")
    private Integer memberId;

    @Column(name = "HinhthucXL")
    private String handlingType;

    @Column(name = "Sotien")
    private Integer fine;

    @Column(name = "ngayxl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "TrangthaiXL")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "MaTV", referencedColumnName = "member_id", insertable = false, updatable = false)
    private SimpleMember member;
}
