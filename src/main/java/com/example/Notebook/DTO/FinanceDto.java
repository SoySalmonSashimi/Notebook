package com.example.Notebook.DTO;

import lombok.Data;

@Data
public class FinanceDto {
    long financeId;
    double groceries;
    double insurance;
    double transport;
    double entertainment;
    double mortgage;
    double loan;
    double subscription;
    double utilities;
    double investments;
}
