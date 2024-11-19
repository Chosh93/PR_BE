package com.study.PR.frontend.account.controller;

import com.study.PR.frontend.account.dto.request.LoginRequest;
import com.study.PR.frontend.account.dto.response.LoginResponse;
import com.study.PR.frontend.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:7700")
@RequestMapping("/api/account")
@Tag(name = "회원", description = "")

public class AccountController {
    @Autowired
    private AccountService accountService;

    //로그인
    @PostMapping("login")
    @Operation(summary = "로그인", description = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "로그신 성공"),
                    @ApiResponse(responseCode = "401", description = "로그인 실패")
            })
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        System.out.println(accountService.login(loginRequest));
        return accountService.login(loginRequest);
    }

}
