package com.bd.budget.services;

import com.bd.budget.models.CustomCategory;

import java.util.List;


public interface CustomCategoryService {
    CustomCategory findCustomCategoryById(Long id);

    List<CustomCategory> findAllCustomCategories();

    CustomCategory addCustomCategory(CustomCategory customCategory);

    CustomCategory updatedCustomCategory(Long id, CustomCategory updatedCustomCategory);

    void deleteCustomCategory(Long customCategoryId);
}