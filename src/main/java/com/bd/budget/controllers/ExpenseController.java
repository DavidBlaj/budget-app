package com.bd.budget.controllers;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.services.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<ExpenseDto> getExpensesData() {
       return expenseService.findAllExpenses();
    }
}