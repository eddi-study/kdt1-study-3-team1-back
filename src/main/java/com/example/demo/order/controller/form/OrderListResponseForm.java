package com.example.demo.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderListResponseForm {

    final private Long productId;
    final private String productName;
    final private Integer productPrice;

}
