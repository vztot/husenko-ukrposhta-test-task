package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponseDto {
    Long id;
    CategoryResponseDto categoryResponseDto;
    String name;
    String description;
    BigDecimal price;
}
