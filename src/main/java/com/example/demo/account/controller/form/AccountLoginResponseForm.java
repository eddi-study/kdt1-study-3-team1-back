package com.example.demo.account.controller.form;

import com.example.demo.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginResponseForm {

    private Long accountId;
    private RoleType roleType;

    public AccountLoginResponseForm(Long accountId, RoleType roleType) {
        this.accountId = accountId;
        this.roleType = roleType;
    }

    public AccountLoginResponseForm toResponseForm(Long accountId, RoleType role){
        return new AccountLoginResponseForm(accountId, role);
    }

}
