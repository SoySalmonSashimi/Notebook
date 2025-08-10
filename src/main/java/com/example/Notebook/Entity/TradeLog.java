package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class TradeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;
    private String broker;
    private long balance;
    private String symbol;
    private int quantity;
    private double pnl;
    private String notes;

    // Declaration of image storage into mysql
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] data;

    @ManyToOne
    private User user;  // links to the "Income" category
}
