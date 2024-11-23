package com.study.PR.frontend.account.entity;

import com.study.PR.frontend.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30, unique = true)
    private String userId;
    @Column(nullable = false, length = 100)
    private String userPw;
    @Column(nullable = false, length = 30)
    private String userName;
    @Column(nullable = false, length = 50, unique = true)
    private String userEmail;
    @Column
    private String userPhone;
    @Column
    private String userImage;
    @Column
    private String userIntroduction;
    @CreationTimestamp
    private Timestamp joinDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> profiles;
}

