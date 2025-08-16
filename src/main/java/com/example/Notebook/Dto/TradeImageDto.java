package com.example.Notebook.Dto;


import lombok.Data;

@Data
public class TradeImageDto {
    private Long id;
    private String filename;
    private byte[] data;
}
