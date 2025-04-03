package com.bd.budget.repositories;

import com.bd.budget.models.Expense;
import com.bd.budget.models.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long>{

}