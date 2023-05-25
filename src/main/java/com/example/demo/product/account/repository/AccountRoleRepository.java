package com.example.demo.product.account.repository;

import com.example.demo.product.account.entity.Account;
import com.example.demo.product.account.entity.AccountRole;
import com.example.demo.product.account.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("select ar.role from AccountRole ar join fetch Role r where ar.account = :account")
    Role findRoleInfoByAccount(Account account);
}
