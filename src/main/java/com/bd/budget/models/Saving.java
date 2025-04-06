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
@Table(name = "savings")
public class Saving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "amount", nullable = false)
    private float amount;

    @CreationTimestamp
    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded;

    @Override
    public String toString() {
        return "Saving -> " + category +
                " | Amount - " + amount +
                " | Date added: " + dateAdded.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }

}