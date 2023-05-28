package com.example.demo.order.repository;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountRole;
import com.example.demo.account.entity.Role;
import com.example.demo.account.entity.RoleType;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.AccountRoleRepository;
import com.example.demo.account.repository.RoleRepository;
import com.example.demo.order.entity.Orders;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.account.entity.RoleType.BUSINESS;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
//@Transactional
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void test() {
        Account account = new Account("choi@naver.com", "password");
        accountRepository.save(account);

        Role role = new Role(BUSINESS);
        roleRepository.save(role);

        AccountRole accountRole = new AccountRole(account, role);
        accountRoleRepository.save(accountRole);

        Product product = new Product("상품1", 10000);
        productRepository.save(product);

        Orders orders = new Orders(product, account);
        orderRepository.save(orders);
    }

}