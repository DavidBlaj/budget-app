package com.bd.budget.repositories;

import com.bd.budget.models.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomCategoryTransaction extends JpaRepository<CustomCategory, Long> {
}