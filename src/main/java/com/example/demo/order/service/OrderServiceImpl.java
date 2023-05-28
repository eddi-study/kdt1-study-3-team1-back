package com.example.demo.order.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.order.controller.form.OrderListRequestForm;
import com.example.demo.order.controller.form.OrderListResponseForm;
import com.example.demo.order.controller.form.OrderRequestForm;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;
    final private ProductRepository productRepository;
    final private AccountRepository accountRepository;

    @Override
    public void register(OrderRequestForm requestForm) {
        final Product product = productRepository.findById(requestForm.getProductId()).get();
        final Account account = accountRepository.findById(requestForm.getAccountId()).get();
//        orderRepository.save(product, account);
    }

    @Override
    public List<OrderListResponseForm> findAllAccountWhoBuyProduct(OrderListRequestForm requestForm){
        List<Orders> orderList = orderRepository.findAllProductWhoByAccount(requestForm.getAccountId());
        List<OrderListResponseForm> responseFormList = new ArrayList<>();

        for(Orders order: orderList){
            Optional<Product> maybeProduct = productRepository.findById(order.getProduct().getProductId());
            if (maybeProduct.isEmpty()) {
                break;
            }
            Product product = maybeProduct.get();
            OrderListResponseForm responseForm = new OrderListResponseForm(product);

            responseFormList.add(responseForm);
        }

        return responseFormList;
    }
}