package com.study.PR.controller;

import com.study.PR.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userId, @RequestParam String userPw){
        return accountService.login(userId, userPw);
    }

}
