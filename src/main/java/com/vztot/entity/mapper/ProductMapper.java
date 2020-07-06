package com.vztot.entity.mapper;

import com.vztot.entity.Product;
import com.vztot.entity.dto.response.ProductResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final CategoryMapper categoryMapper;
    private final DiscountMapper discountMapper;

    public ProductMapper(CategoryMapper categoryMapper, DiscountMapper discountMapper) {
        this.categoryMapper = categoryMapper;
        this.discountMapper = discountMapper;
    }

    public ProductResponseDto buildResponseDtoFromProduct(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setCategoryResponseDto(
                categoryMapper.buildResponseDtoFromCategory(product.getCategory()));
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setDiscountResponseDtoList(product.getDiscountList().stream()
                .map(discount -> discountMapper.buildResponseDtoFromDiscount(discount))
                .collect(Collectors.toList()));
        return dto;
    }
}
