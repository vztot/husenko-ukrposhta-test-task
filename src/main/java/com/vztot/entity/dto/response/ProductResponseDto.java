package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private CategoryResponseDto categoryResponseDto;
    private String name;
    private String description;
    private List<DiscountResponseDto> discountResponseDtoList;
    private BigDecimal price;
}
