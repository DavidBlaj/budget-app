package com.bd.budget.controllers;

import com.bd.budget.models.Income;
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
    public ResponseEntity<Income> findById(@PathVariable("id") Long incomeId) {
        Income income = incomeService.findById(incomeId);
        return ResponseEntity.ok(income);
    }

    @GetMapping
    public ResponseEntity<List<Income>> findAll() {
        return ResponseEntity.ok(incomeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Income> add(@RequestBody Income income) {
        Income newIncome = incomeService.add(income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Income> update(@PathVariable("id") Long incomeId,
                                         @RequestBody Income updatedIncome) {
        Income income = incomeService.update(incomeId, updatedIncome);
        return ResponseEntity.ok(income);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long incomeId) {
        incomeService.delete(incomeId);
        return ResponseEntity.ok("Income entry has been successfully deleted!");
    }

}