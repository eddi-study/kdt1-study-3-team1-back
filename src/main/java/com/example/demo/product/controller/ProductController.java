package com.example.demo.product.controller;

import com.example.demo.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;

    @PostMapping("/product-register")
    public Product registerProduct (@RequestBody ProductRegisterRequestForm productRegisterRequestForm){
        log.info("registerProduct()");

        return productService.register(productRegisterRequestForm);
    }

    @GetMapping("/list")
    public List<Product> productList() {
        log.info("productList()");

        List<Product> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);

        return returnedProductList;
    }

    @GetMapping("/{productId}")
    public Product readProduct (@PathVariable("productId") Long productId){
        log.info("readProduct()");

        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId){
        log.info("deleteProduct()");

        productService.delete(productId);
    }


}
