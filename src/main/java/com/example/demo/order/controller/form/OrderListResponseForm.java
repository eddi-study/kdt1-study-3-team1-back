package com.example.demo.order.controller.form;

import com.example.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderListResponseForm {

    final private Long productId;
    final private String productName;
    final private Integer productPrice;

    public OrderListResponseForm(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
    }
}
