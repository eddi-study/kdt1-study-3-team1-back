package com.example.demo.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRequestRefactoringForm {
    final private Long productId;
    final private String userToken;
}
