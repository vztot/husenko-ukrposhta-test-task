package com.vztot.entity.mapper;

import com.vztot.entity.Discount;
import com.vztot.entity.dto.response.DiscountResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {

    public DiscountResponseDto buildResponseDtoFromDiscount(Discount discount) {
        DiscountResponseDto dto = new DiscountResponseDto();
        dto.setId(discount.getId());
        dto.setName(discount.getName());
        dto.setDescription(discount.getDescription());
        dto.setPercent(discount.getPercent());
        return dto;
    }
}
