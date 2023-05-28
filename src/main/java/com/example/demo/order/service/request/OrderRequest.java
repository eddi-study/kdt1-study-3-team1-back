package com.example.demo.order.service.request;

import lombok.Getter;

@Getter
public class OrderRequest {
    final private Long productId;

    public OrderRequest(Long productId) {
        this.productId = productId;
    }
}
