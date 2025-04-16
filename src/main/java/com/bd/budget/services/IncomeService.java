package com.bd.budget.services;

import com.bd.budget.models.Income;

import java.util.List;

public interface IncomeService {

    List<Income> findAll();

    Income findById(Long incomeId);

    Income add(Income income);

    Income update(Long incomeId, Income updatedIncome);

    void delete(Long incomeId);
}