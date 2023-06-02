package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductModifyRequestForm;
import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRequestForm requestForm);

    List<Product> list();

    Product read(Long productId);

    Boolean delete(Long productId);

    Product modify(ProductModifyRequestForm requestForm);
}