package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class DiscountResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal percent;
}
