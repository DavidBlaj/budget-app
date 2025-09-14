package com.bd.budget.controllers;

import com.bd.budget.models.Income;
import com.bd.budget.models.IncomeCategory;
import com.bd.budget.services.IncomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Income> findIncomeById(@PathVariable("id") Long incomeId) {
        Income income = incomeService.findById(incomeId);
        return ResponseEntity.ok(income);
    }

    @GetMapping
    public ResponseEntity<List<Income>> findAllIncomes() {
        return ResponseEntity.ok(incomeService.findAll());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<IncomeCategory>> findAllIncomeCategories() {
        return ResponseEntity.ok(incomeService.findAllIncomeCategories());
    }

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income newIncome = incomeService.add(income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable("id") Long incomeId,
                                               @RequestBody Income updatedIncome) {
        Income income = incomeService.update(incomeId, updatedIncome);
        return ResponseEntity.ok(income);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable("id") Long incomeId) {
        incomeService.delete(incomeId);
        return ResponseEntity.ok("Income entry has been successfully deleted!");
    }

}