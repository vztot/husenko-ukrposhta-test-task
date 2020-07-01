package com.vztot.entity.mapper;

import com.vztot.entity.Discount;
import com.vztot.entity.dto.response.DiscountResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {

    private final ProductMapper productMapper;

    public DiscountMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public DiscountResponseDto buildResponseDtoFromDiscount(Discount discount) {
        DiscountResponseDto dto = new DiscountResponseDto();
        dto.setId(discount.getId());
        dto.setName(discount.getName());
        dto.setDescription(discount.getDescription());
        dto.setPercent(discount.getPercent());
        dto.setProductList(discount.getProductList()
                .stream()
                .map(productMapper::buildResponseDtoFromProduct)
                .collect(Collectors.toList()));
        return dto;
    }
}
