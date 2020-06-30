package com.vztot.entity.mapper;

import com.vztot.entity.Category;
import com.vztot.entity.dto.response.CategoryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponseDto buildResponseDtoFromCategory(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
