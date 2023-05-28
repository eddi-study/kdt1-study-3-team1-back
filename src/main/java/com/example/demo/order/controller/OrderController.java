package com.example.demo.order.controller;

import com.example.demo.account.service.AccountService;
import com.example.demo.order.controller.form.OrderResponseForm;
import com.example.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    final private OrderService orderService;
    final private AccountService accountService;

    @PostMapping("/order")
    public void orderRegister(@RequestBody OrderResponseForm requestForm) {
        orderService.register(requestForm.toOrderRequestForm());
    }
}
