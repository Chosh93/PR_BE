package com.study.PR.service;

        import com.study.PR.entity.Account;
        import com.study.PR.repository.AccountRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<String> login(String userId, String userPw) {
        Optional<Account> user = accountRepository.login(userId, userPw);
        if(user.isPresent()){
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(401).body("로그인 실패: ID 또는 PW가 틀립니다.");
    }
}
