package com.example.member_management_p3.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "xuly")
@Getter
@Setter
@AllArgsConstructor
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXL")
    private Integer violationId;

    @Column(name = "MaTV")
    private Integer memberId;

    @Column(name = "HinhThucXL")
    private String hadlingType;

    @Column(name = "SoTien")
    private Integer fine;

    @Column(name = "NgayXL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date handlingDate;

    @Column(name = "TrangThaiXL")
    private Integer status;

}
