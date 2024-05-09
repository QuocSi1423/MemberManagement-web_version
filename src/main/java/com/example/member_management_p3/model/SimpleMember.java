package com.example.member_management_p3.model;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Immutable
@Table(name = "simple_member")
@Getter
@Setter
@NoArgsConstructor
public class SimpleMember {
    
    @Id
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;
}
