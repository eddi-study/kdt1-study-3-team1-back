package com.example.demo.order.repository;

import com.example.demo.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllProductWhoByAccount(Long accountId);
}