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
    private long id;
    private String category;
    private float amount;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    @Override
    public String toString() {
        return "Saving -> " + category +
                " | Amount - " + amount +
                " | Date added: " + dateAdded.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }

}