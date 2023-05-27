package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountLoginRequestForm;
import com.example.demo.account.controller.form.AccountLoginResponseForm;
import com.example.demo.account.controller.form.AccountRegisterRequestForm;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    final private AccountService accountService;

    @PostMapping("/create-account")
    public Boolean accountRegister (@RequestBody AccountRegisterRequestForm requestForm) {
        return accountService.register(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login")
    public AccountLoginResponseForm accountLogin (@RequestBody AccountLoginRequestForm requestForm) {
        return accountService.login(requestForm);
    }
}
