package com.bd.budget.services.impl;

import com.bd.budget.models.Income;
import com.bd.budget.repositories.IncomeRepository;
import com.bd.budget.services.IncomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    private IncomeRepository incomeRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<Income> findAllIncomes() {
        return incomeRepository.findAll();
    }
}