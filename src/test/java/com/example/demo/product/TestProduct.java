package com.example.demo.product;

import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TestProduct {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("사업자 회원이 상품을 등록합니다.")
    void 사업자_회원이_상품_정보를_등록_합니다 () {
        final String email = "business@test.com";
        final String productName = "오렌지 티셔츠";
        final Integer productPrice = 5000;
        // 이미지는 파일을 받아오는 방법을 현재 모르겠다.

        ProductRequestForm requestForm = new ProductRequestForm(email, productName, productPrice);
        Product product = productService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(productPrice, product.getProductPrice());
    }
}
