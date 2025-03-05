package com.bd.budget.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    private ExpenseCategory category;
    private float amount;
    private String subCategory;
    private String notes;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    @Override
    public String toString() {
        return "Expense -> " +
                "id - " + id +
                " | Category" + category +
                " | Amount - " + amount +
                " | Sub Category - " + subCategory +
                " | Notes: " + notes +
                " | Date added: " + dateAdded.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }
}