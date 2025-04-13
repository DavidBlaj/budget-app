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
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne()
    private IncomeCategory incomeCategory;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "notes", nullable = false)
    private String notes;

    @CreationTimestamp
    @Column(name = "date_added", nullable = false)
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