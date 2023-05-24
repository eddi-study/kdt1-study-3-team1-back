package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRequestForm requestForm);

    List<Product> list();
}
