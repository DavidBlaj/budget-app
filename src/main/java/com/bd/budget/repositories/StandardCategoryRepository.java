package com.bd.budget.repositories;

import com.bd.budget.models.StandardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandardCategoryRepository extends JpaRepository<StandardCategory, Long> {
}