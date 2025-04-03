package com.bd.budget.repositories;

import com.bd.budget.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long>{

}