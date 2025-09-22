package com.bd.budget.services.impl;

import com.bd.budget.dtos.CustomCategoryUpdateDto;
import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.mappers.CustomCategoryMapper;
import com.bd.budget.models.CustomCategory;
import com.bd.budget.models.StandardCategory;
import com.bd.budget.repositories.CustomCategoryRepository;
import com.bd.budget.repositories.StandardCategoryRepository;
import com.bd.budget.services.CustomCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomCategoryServiceImpl implements CustomCategoryService {
    private final CustomCategoryRepository customCategoryRepository;
    private final StandardCategoryRepository standardCategoryRepository;

    public CustomCategoryServiceImpl(CustomCategoryRepository customCategoryRepository,
                                     StandardCategoryRepository standardCategoryRepository) {
        this.customCategoryRepository = customCategoryRepository;
        this.standardCategoryRepository = standardCategoryRepository;
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
    public CustomCategory updateCustomCategory(Long id, CustomCategoryUpdateDto dto) {
        CustomCategory customCategory = findCustomCategoryById(id);

        StandardCategory standardCategory = null;

        if(dto.getStandardCategoryId() != null) {
            standardCategory = standardCategoryRepository.findById(dto.getStandardCategoryId()).orElseThrow(() ->
                    new ResourceNotFoundException("Standard Category not found"));
        }

        CustomCategoryMapper.applyUpdate(customCategory, dto, standardCategory);

        return customCategoryRepository.save(customCategory);
    }

    @Override
    public void deleteCustomCategory(Long customCategoryId) {
        customCategoryRepository.deleteById(customCategoryId);
    }
}