package com.bd.budget.dtos;

import com.bd.budget.models.ExpenseCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExpenseDto {

    private long id;
    private ExpenseCategory category;
    private float amount;
    private String subCategory;
    private String notes;
    private LocalDateTime dateAdded;
}