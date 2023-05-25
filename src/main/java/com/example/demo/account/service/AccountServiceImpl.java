package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountRegisterRequest;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.*;
import com.example.demo.account.entity.AccountRole;
import com.example.demo.account.entity.Role;
import com.example.demo.backend.account.repository.*;
import com.example.demo.product.account.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final private AccountRepository accountRepository;
    final private AccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;

    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();

    @Override
    public Boolean register(AccountRegisterRequest request) {
        final Optional<Account> maybeAccount = accountRepository.findByEmail(request.getEmail());
        if (maybeAccount.isPresent()) {
            return false;
        }

        final Account account = accountRepository.save(request.toAccount());

        final Role role = roleRepository.findByRoleType(request.getRoleType()).get();
        final AccountRole accountRole =
                new AccountRole(account, role);
        accountRoleRepository.save(accountRole);

        return true;
    }
}
