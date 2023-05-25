package com.example.demo.product.account.repository;

public interface UserTokenRepository {

    void save(String userToken, Long id);

    Long findAccountIdByToken(String accountToken);

}
