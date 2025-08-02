package com.example.Notebook.Controller;

import com.example.Notebook.Dto.FinanceDto;
import com.example.Notebook.Service.FinancialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Finance")
public class FinanceController {

    private final FinancialService financialService;


    public FinanceController(FinancialService financeService)
    {
        this.financialService = financeService;
    }


    @PostMapping("/CreateFinancialEntry/{userId}")
    public ResponseEntity<FinanceDto> createFinancialEntry(@PathVariable long userId, @RequestBody FinanceDto financeDto)
    {
        FinanceDto created =  financialService.createFinancialEntry(userId,financeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }



}
