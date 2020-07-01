package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private CategoryResponseDto categoryResponseDto;
    private String name;
    private String description;
    private BigDecimal price;
}
