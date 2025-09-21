package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.CustomCategory;
import com.bd.budget.repositories.CustomCategoryRepository;
import com.bd.budget.services.CustomCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomCategoryServiceImpl implements CustomCategoryService {
    private final CustomCategoryRepository customCategoryRepository;

    public CustomCategoryServiceImpl(CustomCategoryRepository customCategoryRepository) {
        this.customCategoryRepository = customCategoryRepository;
    }

    @Override
    public CustomCategory findCustomCategoryById(Long customCategoryId) {
        return customCategoryRepository
                .findById(customCategoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The custom category with given id does not exist: " + customCategoryId));
    }

    @Override
    public List<CustomCategory> findAllCustomCategories() {
        return customCategoryRepository.findAll();
    }

    @Override
    public CustomCategory addCustomCategory(CustomCategory customCategory) {
        return customCategoryRepository.save(customCategory);
    }

    @Override
    public CustomCategory updatedCustomCategory(Long customCategoryId, CustomCategory updatedCustomCategory) {
        CustomCategory customCategory = findCustomCategoryById(customCategoryId);

        customCategory.setName(updatedCustomCategory.getName());
        customCategory.setStandardCategory(updatedCustomCategory.getStandardCategory());
        customCategory.setUser(updatedCustomCategory.getUser());

        return customCategoryRepository.save(customCategory);
    }

    @Override
    public void deleteCustomCategory(Long customCategoryId) {
        customCategoryRepository.deleteById(customCategoryId);
    }
}