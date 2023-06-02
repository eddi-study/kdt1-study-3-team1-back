package com.example.demo.order.service;

import com.example.demo.order.controller.form.OrderListRequestForm;
import com.example.demo.order.controller.form.OrderListResponseForm;
import com.example.demo.order.controller.form.OrderRequestForm;

import java.util.List;

public interface OrderService {
    void register(OrderRequestForm orderRequestForm);

    List<OrderListResponseForm> findAllAccountWhoBuyProduct(
            Long accountId);
}