package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TradeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private LocalDateTime entryTime;
    private double entryPrice;
    private LocalDateTime exitTime;
    private double exitPrice;
    private int quantity;
    private double pnl;
    private String strategy;
    private String notes;

    @ManyToOne
    private Finance finance;  // links to the "Income" category
}
