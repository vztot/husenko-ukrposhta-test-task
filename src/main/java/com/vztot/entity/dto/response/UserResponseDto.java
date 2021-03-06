package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private BigDecimal money;
}
