package com.bd.budget.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionUpdateDto {

    private BigDecimal amount;
    private Long standardCategoryId;
    private Long customCategoryId;
    private LocalDate date;
    private String description;

}