package com.example.Notebook.Dto;


import lombok.Data;

@Data
public class TradeImageDto {
    private long id;
    private String filename;
    private byte[] data;
}
