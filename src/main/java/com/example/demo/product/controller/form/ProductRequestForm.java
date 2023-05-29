package com.example.demo.product.controller.form;

import com.example.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRequestForm {

    final private Long accountId;
    final private String productName;
    final private Integer productPrice;

    public Product toProduct(){
        return new Product(productName, productPrice);
    }
}