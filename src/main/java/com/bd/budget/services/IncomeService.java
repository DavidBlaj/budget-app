package com.bd.budget.services;

import com.bd.budget.models.Income;

import java.util.List;

public interface IncomeService {

    List<Income> findAllIncomes();
}