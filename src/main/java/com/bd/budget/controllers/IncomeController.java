package com.bd.budget.controllers;

import com.bd.budget.models.Income;
import com.bd.budget.services.IncomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/incomes")
public class IncomeController {
    private IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<Income> getIncomes() {
        return incomeService.findAll();
    }
}