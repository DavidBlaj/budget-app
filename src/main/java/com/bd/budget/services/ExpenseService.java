package com.bd.budget.services;

import com.bd.budget.dtos.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findAllExpenses();
}