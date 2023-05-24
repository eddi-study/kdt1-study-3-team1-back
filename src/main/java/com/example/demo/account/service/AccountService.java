package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountRegisterRequestForm;

public interface AccountService {
    Boolean register(AccountRegisterRequestForm accountRegisterRequest);
}
