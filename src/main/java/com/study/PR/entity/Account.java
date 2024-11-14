package com.study.PR.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 30)
    private String userId;
    @Column(nullable = false, length = 100)
    private String userPw;
    @Column(nullable = false, length = 30)
    private String userName;
    @Column(nullable = false, length = 50)
    private String userEmail;
    @Column
    private String userPhone;
    @CreationTimestamp
    private Timestamp joinDate;
}

