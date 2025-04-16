package com.bd.budget.controllers;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.models.Expense;
import com.bd.budget.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> findById(@PathVariable("id") Long expenseId) {
        Expense expense = expenseService.findById(expenseId);
        return ResponseEntity.ok(expense);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> findAll() {
        return ResponseEntity.ok(expenseService.findAll());
    }

    @PostMapping
    public ResponseEntity<Expense> add(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.add(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<Expense> update(@PathVariable("id") Long expenseId,
                                          @RequestBody Expense updatedExpense) {
        Expense expense = expenseService.update(expenseId, updatedExpense);
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long expenseId) {
        expenseService.delete(expenseId);
        return ResponseEntity.ok("Expense entry has been successfully deleted!");
    }


}