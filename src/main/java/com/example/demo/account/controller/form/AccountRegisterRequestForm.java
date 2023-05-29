package com.example.demo.account.controller.form;

import com.example.demo.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(email, password, roleType);
    }
}