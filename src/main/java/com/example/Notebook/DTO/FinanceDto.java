package com.example.Notebook.DTO;

import lombok.Data;

@Data
public class FinanceDto {
    private long financeId;
    private int income;
    private int numberOfDependencies;
    private double groceries;
    private double insurance;
    private double transport;
    private double entertainment;
    private double mortgage;
    private double loan;
    private double subscription;
    private double utilities;
    private double investments;
}
