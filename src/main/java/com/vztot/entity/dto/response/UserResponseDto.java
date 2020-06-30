package com.vztot.entity.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserResponseDto {
    Long id;
    String name;
    BigDecimal money;
}
