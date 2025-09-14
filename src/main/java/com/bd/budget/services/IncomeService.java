package com.bd.budget.services;

import com.bd.budget.models.Income;
import com.bd.budget.models.IncomeCategory;

import java.util.List;

public interface IncomeService {

    List<Income> findAll();

    List<IncomeCategory> findAllIncomeCategories();

    Income findById(Long incomeId);

    Income add(Income income);

    Income update(Long incomeId, Income updatedIncome);

    void delete(Long incomeId);
}