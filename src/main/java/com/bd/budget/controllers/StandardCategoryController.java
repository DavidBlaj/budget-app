package com.bd.budget.controllers;

import com.bd.budget.models.StandardCategory;
import com.bd.budget.services.StandardCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standard_categories")
public class StandardCategoryController {
    private final StandardCategoryService service;

    public StandardCategoryController(StandardCategoryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<StandardCategory> findStandardCategoryById(@PathVariable("id") Long id) {
        StandardCategory standardCategory = service.findStandardCategoryById(id);

        return ResponseEntity.ok(standardCategory);
    }

    @GetMapping
    public ResponseEntity<List<StandardCategory>> findAllStandardCategories() {
        List<StandardCategory> standardCategories = service.findAllStandardCategories();

        return ResponseEntity.ok(standardCategories);
    }

    @PostMapping
    public ResponseEntity<StandardCategory> addStandardCategory(@RequestBody StandardCategory standardCategory) {
        StandardCategory newStandardCategory = service.addStandardCategory(standardCategory);
        return ResponseEntity.ok(newStandardCategory);
    }

    @PutMapping("{id}")
    public ResponseEntity<StandardCategory> updateStandardCategory(@PathVariable("id") Long id,
                                                                   @RequestBody StandardCategory updateStandardCategory) {
        StandardCategory standardCategory = service.updatedStandardCategory(id, updateStandardCategory);

        return ResponseEntity.ok(standardCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStandardCategory(@PathVariable("id") Long id) {
        service.deleteStandardCategory(id);

        return ResponseEntity.ok("Standard category has been successfully deleted.");
    }

}