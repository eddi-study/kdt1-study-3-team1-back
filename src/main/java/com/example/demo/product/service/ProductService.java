package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.product.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> list();
}
