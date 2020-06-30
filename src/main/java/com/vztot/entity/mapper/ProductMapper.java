package com.vztot.entity.mapper;

import com.vztot.entity.Product;
import com.vztot.entity.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public ProductResponseDto buildResponseDtoFromProduct(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setCategoryResponseDto(
                categoryMapper.buildResponseDtoFromCategory(product.getCategory()));
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
