package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "tradingLog", cascade = CascadeType.ALL)
    private List<TradeImage> listOfImages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // links to the "Income" category



}
