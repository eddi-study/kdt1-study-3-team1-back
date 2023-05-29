package com.example.demo.order.controller;

import com.example.demo.account.service.AccountService;
import com.example.demo.order.controller.form.OrderListRequestForm;
import com.example.demo.order.controller.form.OrderListResponseForm;
import com.example.demo.order.controller.form.OrderResponseForm;
import com.example.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    final private OrderService orderService;
    final private AccountService accountService;

    @PostMapping("/order-product")
    public void orderRegister(@RequestBody OrderResponseForm requestForm) {
        orderService.register(requestForm.toOrderRequestForm());
    }

    @GetMapping("/list")
    public List<OrderListResponseForm> orderList (@RequestBody OrderListRequestForm requestForm) {
        return orderService.findAllAccountWhoBuyProduct(requestForm);
    }
}
