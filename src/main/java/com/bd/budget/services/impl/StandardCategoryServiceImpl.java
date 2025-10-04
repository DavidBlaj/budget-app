package com.bd.budget.services.impl;

import com.bd.budget.exceptions.ResourceNotFoundException;
import com.bd.budget.models.StandardCategory;
import com.bd.budget.repositories.StandardCategoryRepository;
import com.bd.budget.services.StandardCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardCategoryServiceImpl implements StandardCategoryService {
    private final StandardCategoryRepository standardCategoryRepository;

    public StandardCategoryServiceImpl(StandardCategoryRepository standardCategoryRepository) {
        this.standardCategoryRepository = standardCategoryRepository;
    }

    @Override
    public StandardCategory findStandardCategoryById(Long standardCategoryId) {
        return standardCategoryRepository
                .findById(standardCategoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The standard category with given id does not exist: " + standardCategoryId));
    }

    @Override
    public List<StandardCategory> findAllStandardCategories() {
        return standardCategoryRepository.findAll();
    }

    @Override
    public StandardCategory addStandardCategory(StandardCategory standardCategory) {
        return standardCategoryRepository.save(standardCategory);
    }

    @Override
    public StandardCategory updateStandardCategory(Long standardCategoryId, StandardCategory updatedStandardCategory) {
        StandardCategory standardCategory = findStandardCategoryById(standardCategoryId);

        standardCategory.setName(updatedStandardCategory.getName());
        standardCategory.setColor(updatedStandardCategory.getColor());
        standardCategory.setTransactionType(updatedStandardCategory.getTransactionType());

        return standardCategoryRepository.save(standardCategory);
    }

    @Override
    public void deleteStandardCategory(Long standardCategoryId) {
        standardCategoryRepository.deleteById(standardCategoryId);
    }
}