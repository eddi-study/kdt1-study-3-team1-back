package com.example.demo.order.service;

import com.example.demo.order.controller.form.OrderListRequestForm;
import com.example.demo.order.controller.form.OrderListResponseForm;
import com.example.demo.order.controller.form.OrderRequestForm;
import com.example.demo.order.controller.form.OrderRequestRefactoringForm;

import java.util.List;

public interface OrderService {
    void register(OrderRequestForm orderRequestForm);
    void registerRefactoring(OrderRequestRefactoringForm requestForm);
    List<OrderListResponseForm> findAllAccountWhoBuyProduct(
            Long accountId);
}