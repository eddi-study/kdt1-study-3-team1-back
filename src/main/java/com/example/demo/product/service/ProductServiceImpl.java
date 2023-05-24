package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    final private ProductRepository productRepository;

    @Override
    public Product register(ProductRequestForm requestForm){
//        final RoleType roleType = BUSINESS; // roleType 을 따로 만들었을 경우
//        final String roleType = "BUSINESS"; // roleType 을 입력으로 받아올 경우
//
//        Optional<Account> maybeAccount = productRepository.findByEmail(requestForm.getEmail());
//        Optional<AccountRole> maybeAccountRole = accountRoleRepository.findByAccount(maybeAccount);

        return null;
    }

    @Override
    public List<Product> list(){
        return null;
    }
}
