package com.vztot.controller;

import com.vztot.entity.dto.response.ProductResponseDto;
import com.vztot.entity.mapper.ProductMapper;
import com.vztot.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/list")
    public List<ProductResponseDto> getAll() {
        return productService.getAll()
                .stream()
                .map(productMapper::buildResponseDtoFromProduct)
                .collect(Collectors.toList());
    }
}
