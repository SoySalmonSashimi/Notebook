package com.example.Notebook.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HealthDto {
    private long healthId;
    private double height;
    private double weight;
    private String sportsName;
    private double distance;
    private LocalDateTime dateTime;
}
