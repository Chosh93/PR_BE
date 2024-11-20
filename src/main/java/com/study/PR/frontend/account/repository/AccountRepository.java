package com.study.PR.frontend.account.repository;

import com.study.PR.frontend.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // 로그인
    @Query(value = "SELECT * FROM account WHERE user_id = :userId AND user_pw = :userPw", nativeQuery = true)
    Optional<Account> login(@Param("userId") String userId, @Param("userPw") String userPw);

    // 아이디 중복체크
    @Query("SELECT COUNT(a) > 0 FROM Account a WHERE a.userId = :userId")
    boolean existsByUserId(@Param("userId") String userId);

    // 이메일 중복체크
    @Query("SELECT COUNT(a) > 0 FROM Account a WHERE a.userEmail = :userEmail")
    boolean existsByUserEmail(@Param("userEmail") String userEmail);
}
