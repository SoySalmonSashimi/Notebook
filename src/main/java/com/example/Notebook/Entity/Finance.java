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
    long financeId;
    double groceries;
    double insurance;
    double transport;
    double entertainment;
    double mortgage;
    double loan;
    double subscription;
    double utilities;
    double investments;
}
