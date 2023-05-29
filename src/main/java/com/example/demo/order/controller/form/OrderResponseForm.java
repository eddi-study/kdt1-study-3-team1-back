package com.example.demo.order.controller.form;

import com.example.demo.account.controller.form.AccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderResponseForm {
    final private Long productId;
    final private Long accountId;

    public OrderRequestForm toOrderRequestForm () {
        return new OrderRequestForm(productId, accountId);
    }
}