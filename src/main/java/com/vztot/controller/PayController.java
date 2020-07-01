package com.vztot.controller;

import com.vztot.service.PayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pay")
@RestController
public class PayController {
    private final PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping
    public String addMoneyToUser(@RequestParam Long userId, @RequestParam Long productId) {
        return payService.buy(userId, productId) ? "Success!" : "Not enough money!";
    }
}
