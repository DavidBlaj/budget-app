package com.bd.budget.controllers;

import com.bd.budget.models.CustomCategory;
import com.bd.budget.services.CustomCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custom_categories")
public class CustomCategoryController {
    private final CustomCategoryService service;

    public CustomCategoryController(CustomCategoryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomCategory> findCustomCategoryById(@PathVariable("id") Long id) {
        CustomCategory customCategory = service.findCustomCategoryById(id);

        return ResponseEntity.ok(customCategory);
    }

    @GetMapping
    public ResponseEntity<List<CustomCategory>> findAllCustomCategories() {
        List<CustomCategory> customCategories = service.findAllCustomCategories();

        return ResponseEntity.ok(customCategories);
    }

    @PostMapping
    public ResponseEntity<CustomCategory> addCustomCategory(@RequestBody CustomCategory customCategory) {
        CustomCategory newCustomCategory = service.addCustomCategory(customCategory);
        return ResponseEntity.ok(newCustomCategory);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomCategory> updateCustomCategory(@PathVariable("id") Long id,
                                                                   @RequestBody CustomCategory updateCustomCategory) {
        CustomCategory customCategory = service.updatedCustomCategory(id, updateCustomCategory);

        return ResponseEntity.ok(customCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomCategory(@PathVariable("id") Long id) {
        service.deleteCustomCategory(id);

        return ResponseEntity.ok("Custom category has been successfully deleted.");
    }

}