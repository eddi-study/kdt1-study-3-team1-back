package com.example.demo.product.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.Role;
import com.example.demo.account.entity.RoleType;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.AccountRoleRepository;
import com.example.demo.account.repository.RoleRepository;
import com.example.demo.product.controller.form.ProductRequestForm;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.account.entity.RoleType.BUSINESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    final private ProductRepository productRepository;
    final private AccountRepository accountRepository;
    final private AccountRoleRepository accountRoleRepository;
    final private RoleRepository roleRepository;

    @Override
    public Product register(ProductRequestForm requestForm){
        final RoleType roleType = BUSINESS;

        Optional<Account> maybeAccount =
                accountRepository.findByAccountId(requestForm.getAccountId());
        Account account = maybeAccount.get();

        Role role = accountRoleRepository.findRoleInfoByAccount(account);

        if(!roleType.equals(role.getRoleType())) {
            log.info("사업자가 아닌 사용자는 상품을 등록할 수 없습니다.");
            return null;
        }
        else {
            Product product = requestForm.toProduct();
            productRepository.save(product);
            return product;
        }
    }

    @Override
    public List<Product> list(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public Product read(Long productId){
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isEmpty()){
            log.info("상품 정보가 존재하지 않습니다.");
            return null;
        }

        return maybeProduct.get();
    }

    @Override
    public Boolean delete(Long productId){
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isPresent()){
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public Product modify(Long productId, ProductRequestForm requestForm){
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isEmpty()){
            log.info("상품 정보가 존재하지 않습니다.");
            return null;
        }

        Product product = maybeProduct.get();
        product.setProductName(requestForm.getProductName());
        product.setProductPrice(requestForm.getProductPrice());

        return productRepository.save(product);
    }
}