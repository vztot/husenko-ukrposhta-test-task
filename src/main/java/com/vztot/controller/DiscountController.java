package com.vztot.controller;

import com.vztot.entity.dto.response.DiscountResponseDto;
import com.vztot.entity.mapper.DiscountMapper;
import com.vztot.service.DiscountService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/discount")
@RestController
public class DiscountController {

    private final DiscountService discountService;
    private final DiscountMapper discountMapper;

    public DiscountController(DiscountService discountService, DiscountMapper discountMapper) {
        this.discountService = discountService;
        this.discountMapper = discountMapper;
    }

    @GetMapping("/list")
    public List<DiscountResponseDto> getAll() {
        return discountService.getAll()
                .stream()
                .map(discountMapper::buildResponseDtoFromDiscount)
                .collect(Collectors.toList());
    }
}
