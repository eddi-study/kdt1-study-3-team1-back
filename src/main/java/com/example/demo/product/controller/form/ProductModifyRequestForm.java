package com.example.demo.product.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductModifyRequestForm {

    final private Long accountId;
    final private Long productId;
    final private String productName;
    final private Integer productPrice;
}
