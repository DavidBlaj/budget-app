package com.bd.budget.services;

import com.bd.budget.models.StandardCategory;

import java.util.List;


public interface StandardCategoryService {
    StandardCategory findStandardCategoryById(Long standardCategoryId);

    List<StandardCategory> findAllStandardCategories();

    StandardCategory addStandardCategory(StandardCategory standardCategory);

    StandardCategory updatedStandardCategory(Long standardCategoryId, StandardCategory updatedStandardCategory);

    void deleteStandardCategory(Long standardCategoryId);
}