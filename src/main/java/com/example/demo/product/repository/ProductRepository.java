package com.example.demo.product.repository;

import com.example.demo.account.entity.Account;
import com.example.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
