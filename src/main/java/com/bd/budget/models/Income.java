package com.bd.budget.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    private IncomeCategory incomeCategory;
    private float amount;
    private String notes;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    @Override
    public String toString() {
        return "Income  -> " +
                " Id - " + id +
                " | Category - " + incomeCategory +
                " | Amount - " + amount +
                " | Notes - " + notes +
                " | Date added - " + dateAdded.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }

}