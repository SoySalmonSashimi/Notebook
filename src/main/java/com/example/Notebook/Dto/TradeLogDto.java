package com.example.Notebook.Dto;

import lombok.Data;


@Data
public class TradeLogDto {
    private Long tradeId;
    private String broker;
    private long balance;
    private String symbol;
    private int quantity;
    private double pnl;
    private String notes;

}
