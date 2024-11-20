package com.study.PR.frontend.account.service;

        import com.study.PR.frontend.account.dto.request.LoginRequest;
        import com.study.PR.frontend.account.dto.request.SignUpRequest;
        import com.study.PR.frontend.account.dto.response.LoginResponse;
        import com.study.PR.frontend.account.dto.response.SignUpResponse;
        import com.study.PR.frontend.account.entity.Account;
        import com.study.PR.frontend.account.repository.AccountRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        Optional<Account> user = accountRepository.login(loginRequest.getUserId(), loginRequest.getUserPw());
        if(user.isPresent()){
            return ResponseEntity.ok(
                    LoginResponse.builder()
                            .success(true)
                            .message("로그인 성공")
                            .build()
            );
        }
        return ResponseEntity.status(401).body(
                LoginResponse.builder()
                        .success(false)
                        .message("로그인 실패: ID 또는 PW가 틀립니다.")
                        .build()
        );
    }

    public ResponseEntity<SignUpResponse> signUp(SignUpRequest signUpRequest){
        if (accountRepository.existsByUserId(signUpRequest.getUserId())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new SignUpResponse(false,"이미 존재하는 아이디입니다."));
        }

        if (accountRepository.existsByUserEmail(signUpRequest.getUserEmail())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new SignUpResponse(false,"이미 존재하는 이메일입니다."));
        }

        Account newAccount = new Account();
        newAccount.setUserId(signUpRequest.getUserId());
        newAccount.setUserPw(signUpRequest.getUserPw());
        newAccount.setUserName(signUpRequest.getUserName());
        newAccount.setUserEmail(signUpRequest.getUserEmail());
        newAccount.setUserPhone((signUpRequest.getUserPhone()));
        accountRepository.save(newAccount);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SignUpResponse(true, "회원가입 성공"));
    }
}
