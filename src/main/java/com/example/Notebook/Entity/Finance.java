package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "finance")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finance_id")
    private long financeId;
    private int income;
    private int numberOfDependencies;
    private double groceries;
    private double insurance;
    private double transport;
    private double entertainment;
    private double mortgage;
    private double loan;
    private double subscription;
    private double utilities;
    private double investments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
