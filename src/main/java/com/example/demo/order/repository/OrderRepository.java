package com.example.demo.order.repository;

import com.example.demo.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("select or from Orders or where or.account.id = :accountId")
    List<Orders> findAllProductWhoByAccount(Long accountId);
}