package com.example.demo.product.account.service;

import com.example.demo.product.account.controller.form.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest registerRequest);
}
