package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRegisterRequestForm requestForm);

    List<Product> list();

    Product read(Long productId);

    void delete(Long productId);
}
