package com.example.demo.account.entity;

import com.example.demo.account.controller.form.AccountLoginResponseForm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @Getter
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Getter
    private String password;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountRole accountRole;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;

        accountRole.setAccount(this);
    }

}
