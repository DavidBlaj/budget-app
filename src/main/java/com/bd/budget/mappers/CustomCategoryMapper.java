package com.bd.budget.mappers;

import com.bd.budget.dtos.CustomCategoryUpdateDto;
import com.bd.budget.models.CustomCategory;
import com.bd.budget.models.StandardCategory;

public class CustomCategoryMapper {

    public static void applyUpdate(
            CustomCategory customCategory, CustomCategoryUpdateDto dto, StandardCategory standardCategory) {
        if(dto.getName() != null) {
            customCategory.setName(dto.getName());
        }

        if(dto.getStandardCategoryId() != null) {
            customCategory.setStandardCategory(standardCategory);
        }
    }
}