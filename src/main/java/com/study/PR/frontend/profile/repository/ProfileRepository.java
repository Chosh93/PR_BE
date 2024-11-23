package com.study.PR.frontend.profile.repository;

import com.study.PR.frontend.account.entity.Account;
import com.study.PR.frontend.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN FETCH a.profiles")
    List<Account> findAllAccountsWithProfile();

    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN FETCH a.profiles WHERE a.userId = :userId")
    Account findAccountWithProfileByUserId(@Param("userId") String userId);
}
