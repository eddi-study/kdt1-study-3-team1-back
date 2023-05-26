package com.example.demo.product.controller;

import com.example.demo.product.controller.form.ProductRequestForm;
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
    public Boolean deleteProduct (@PathVariable("productId") Long productId){
        log.info("deleteProduct()");

        return productService.delete(productId);
    }

    @PutMapping("/{productId}")
    public Product modifyProduct (@PathVariable("productId") Long productId,
                                  @RequestBody ProductRequestForm requestForm) {
        log.info("modifyProduct(): "+  requestForm +", id: "+productId);

        return productService.modify(productId, requestForm);
    }

}
