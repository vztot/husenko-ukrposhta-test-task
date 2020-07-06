package com.vztot.entity.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private BigDecimal money;
}
