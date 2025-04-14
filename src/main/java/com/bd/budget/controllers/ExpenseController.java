package com.bd.budget.controllers;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.models.Expense;
import com.bd.budget.services.ExpenseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<ExpenseDto> getExpenses() {
        return expenseService.findAll();
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.add(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> findById(@PathVariable("id") Long expenseId) {
        Expense expense = expenseService.findById(expenseId);
        return ResponseEntity.ok(expense);
    }
}