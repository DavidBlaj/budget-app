package com.bd.budget.services;

import com.bd.budget.dtos.ExpenseDto;
import com.bd.budget.models.Expense;
import com.bd.budget.models.ExpenseCategory;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findAll();

    List<ExpenseCategory> findAllExpenseCategories();

    Expense findById(Long expenseId);

    Expense add(Expense expense);

   Expense update(Long expenseId, Expense updatedExpense);

   void delete(Long expenseId);
}