package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class DiscountResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal percent;
    private List<ProductResponseDto> productList;
}
