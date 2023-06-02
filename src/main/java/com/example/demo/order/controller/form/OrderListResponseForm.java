package com.example.demo.order.controller.form;

import com.example.demo.order.entity.Orders;
import com.example.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class OrderListResponseForm {

    final private Long orderId;
    final private LocalDateTime orderDate;
    final private Long productId;
    final private String productName;
    final private Integer productPrice;

    public OrderListResponseForm(Product product, Orders orders) {
        this.orderId = orders.getId();
        this.orderDate = orders.getOrderDate();
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
    }
}
