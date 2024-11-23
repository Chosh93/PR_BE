package com.study.PR.frontend.profile.entity;

import com.study.PR.frontend.account.entity.Account;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 50)
    private String period;
    @Column(nullable = false, length = 100)
    private String role;
    @Column(nullable = false, length = 255) // 기술은 쉼표로 구분된 문자열로 저장
    private String technologies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // 기술 리스트를 쉼표로 구분된 문자열을 List로 변환하여 사용하기 위한 메소드
    public List<String> getTechnologiesAsList() {
        return List.of(technologies.split(","));
    }

    // 기술 리스트를 List에서 쉼표로 구분된 문자열로 변환하여 저장하기 위한 메소드
    public void setTechnologiesFromList(List<String> technologyList) {
        this.technologies = String.join(",", technologyList);
    }
}
