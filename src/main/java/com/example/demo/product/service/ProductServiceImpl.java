package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    final private ProductRepository productRepository;

    @Override
    public Product register(ProductRegisterRequestForm requestForm){
        final String roleType = "BUSINESS";

        Optional<Account> maybeAccount = productRepository.findByEmail(requestForm.getEmail());

        if(!(maybeAccount.getAccountRole()).equals(roleType)){
            log.info("사업자가 아닌 사용자는 상품을 등록할 수 없습니다.");
            return null;
        }
        final Product product = requestForm.toProduct();

        return productRepository.save(product);
    }

    @Override
    public List<Product> list(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }
}
