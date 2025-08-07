package com.example.Notebook.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TradeLogDto {
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
}
