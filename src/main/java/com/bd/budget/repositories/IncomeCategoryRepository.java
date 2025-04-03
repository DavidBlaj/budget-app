package com.bd.budget.repositories;

import com.bd.budget.models.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory, Long>{

}