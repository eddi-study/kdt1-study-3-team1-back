package com.example.demo.order.controller;

import com.example.demo.account.service.AccountService;
import com.example.demo.order.controller.form.OrderListRequestForm;
import com.example.demo.order.controller.form.OrderListResponseForm;
import com.example.demo.order.controller.form.OrderResponseForm;
import com.example.demo.order.controller.form.OrderResponseRefactoringForm;
import com.example.demo.order.service.OrderService;
import com.example.demo.redis.RedisService;
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
    final private RedisService redisService;

    @PostMapping("/order-product")
    public void orderRegister(@RequestBody OrderResponseForm requestForm) {
        orderService.register(requestForm.toOrderRequestForm());
    }

    @GetMapping("/list/{accountId}")
    public List<OrderListResponseForm> orderList (@PathVariable("accountId") Long accountId) {
        return orderService.findAllAccountWhoBuyProduct(accountId);
    }
    @PostMapping("/order-product-refactoring")
    public void orderRegisterRefactoring(@RequestBody OrderResponseRefactoringForm responseForm) {
        orderService.registerRefactoring(responseForm.toOrderRequestRefactoringForm());
    }

    @GetMapping("/list-refactoring/{userToken}")
    public List<OrderListResponseForm> refactoringOrderList (@PathVariable("userToken") String userToken) {

        Long accountId = redisService.getValueByKey(userToken);

        return orderService.findAllAccountWhoBuyProduct(accountId);
    }
}
