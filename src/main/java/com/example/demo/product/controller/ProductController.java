package com.example.demo.product.controller;

import com.example.demo.product.controller.form.ProductModifyRequestForm;
import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.controller.form.ProductRequestRefactoringForm;
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
    public Product registerProduct (@RequestBody ProductRequestForm productRequestForm){
        log.info("registerProduct()");
        return productService.register(productRequestForm);
    }
    @PostMapping("/product-register-refactoring")
    public Product registerProductRefactoring (@RequestBody ProductRequestRefactoringForm requestForm){
        log.info("registerProduct()");
        return productService.registerRefactoring(requestForm);
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
        log.info("readProduct()" + productId);

        return productService.read(productId);
    }

    @DeleteMapping("/{productId}")
    public Boolean deleteProduct (@PathVariable("productId") Long productId){
        log.info("deleteProduct()");

        return productService.delete(productId);
    }

    @PutMapping("/product-update")
    public Product modifyProduct (@RequestBody ProductModifyRequestForm requestForm) {
        log.info("modifyProduct(): "+  requestForm +", id: ");

        return productService.modify(requestForm);
    }

}