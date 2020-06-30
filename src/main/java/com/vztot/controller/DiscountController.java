package com.vztot.controller;

import com.vztot.entity.Discount;
import com.vztot.service.DiscountService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/all")
    public List<Discount> findALl() {
        return discountService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Discount discount) {
        discountService.create(discount);
    }
}
