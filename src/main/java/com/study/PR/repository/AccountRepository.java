package com.study.PR.repository;

import com.study.PR.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE user_id = :userId AND user_pw = :userPw", nativeQuery = true)
    Optional<Account> login(@Param("userId") String userId, @Param("userPw") String userPw);
}
