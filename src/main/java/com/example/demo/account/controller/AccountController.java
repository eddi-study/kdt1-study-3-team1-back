package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountLoginRequestForm;
import com.example.demo.account.controller.form.AccountLoginResponseForm;
import com.example.demo.account.controller.form.AccountRegisterRequestForm;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import com.example.demo.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    final private AccountService accountService;
    final private RedisService redisService;

    @PostMapping("/create-account")
    public Boolean accountRegister (@RequestBody AccountRegisterRequestForm requestForm) {
        return accountService.register(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login")
    public AccountLoginResponseForm accountLogin (@RequestBody AccountLoginRequestForm requestForm) {
        return accountService.login(requestForm);
    }
    @PostMapping("/login-refactoring")
    public String getUserInfo(@RequestBody AccountLoginRequestForm requestForm) {
        final Long NO_ACCOUNT = -1L;

        Long accountId = accountService.findAccountIdByEmail(requestForm.getEmail());

        String userToken = UUID.randomUUID().toString();

        redisService.setKeyAndValue(userToken, accountId);

        return userToken;
    }
}
