package com.bd.budget.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomCategoryUpdateDto {
    private String name;
    private Long standardCategoryId;
}