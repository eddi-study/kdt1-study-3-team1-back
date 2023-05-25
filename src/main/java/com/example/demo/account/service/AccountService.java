package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest registerRequest);
}
