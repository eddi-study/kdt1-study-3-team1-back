package com.example.demo.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class OrderResponseRefactoringForm {


    final private Long productId;
    final private String userToken;

    public OrderRequestRefactoringForm toOrderRequestRefactoringForm() {
        return new OrderRequestRefactoringForm(productId, userToken);
    }
}

