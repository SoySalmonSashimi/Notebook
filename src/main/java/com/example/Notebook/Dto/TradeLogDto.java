package com.example.Notebook.Dto;

import lombok.Data;


@Data
public class TradeLogDto {
    private long tradeId;
    private String broker;
    private long balance;
    private long Entry;
    private long exit;
    private String symbol;
    private int quantity;
    private double pnl;
    private String notes;

}
