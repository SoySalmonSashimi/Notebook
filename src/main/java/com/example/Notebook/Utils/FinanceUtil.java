package com.example.Notebook.Utils;

import com.example.Notebook.DTO.FinanceDto;
import com.example.Notebook.Entity.Finance;

import java.util.ArrayList;
import java.util.List;

public class FinanceUtil {


    public static FinanceDto toDto(Finance finance)
    {
        FinanceDto financeDto= new FinanceDto();
        financeDto.setFinanceId(finance.getFinanceId());
        financeDto.setUtilities(finance.getUtilities());
        financeDto.setLoan(finance.getLoan());
        financeDto.setInsurance(finance.getInsurance());
        financeDto.setNumberOfDependencies(finance.getNumberOfDependencies());
        financeDto.setSubscription(finance.getSubscription());
        financeDto.setMortgage(finance.getMortgage());
        financeDto.setTransport(finance.getTransport());
        financeDto.setInvestments(finance.getInvestments());
        financeDto.setIncome(finance.getIncome());
        financeDto.setEntertainment(finance.getEntertainment());
        financeDto.setGroceries(finance.getGroceries());
        return financeDto;

    }

    public static Finance fromDto(FinanceDto financeDto)
    {
        Finance finance = new Finance();
        finance.setFinanceId(financeDto.getFinanceId());
        finance.setUtilities(financeDto.getUtilities());
        finance.setLoan(financeDto.getLoan());
        finance.setInsurance(financeDto.getInsurance());
        finance.setNumberOfDependencies(financeDto.getNumberOfDependencies());
        finance.setSubscription(financeDto.getSubscription());
        finance.setMortgage(financeDto.getMortgage());
        finance.setTransport(financeDto.getTransport());
        finance.setInvestments(financeDto.getInvestments());
        finance.setIncome(financeDto.getIncome());
        finance.setEntertainment(financeDto.getEntertainment());
        finance.setGroceries(financeDto.getGroceries());
        return finance;

    }

    public static List<FinanceDto> toDtoList(List<Finance> financeList)
    {
        List<FinanceDto> financeDtoList =  new ArrayList<>();
        FinanceDto financeDto = null;

        for(Finance finance: financeList)
        {
            financeDto = new FinanceDto();
            financeDto.setFinanceId(finance.getFinanceId());
            financeDto.setUtilities(finance.getUtilities());
            financeDto.setLoan(finance.getLoan());
            financeDto.setInsurance(finance.getInsurance());
            financeDto.setNumberOfDependencies(finance.getNumberOfDependencies());
            financeDto.setSubscription(finance.getSubscription());
            financeDto.setMortgage(finance.getMortgage());
            financeDto.setTransport(finance.getTransport());
            financeDto.setInvestments(finance.getInvestments());
            financeDto.setIncome(finance.getIncome());
            financeDto.setEntertainment(finance.getEntertainment());
            financeDto.setGroceries(finance.getGroceries());
            financeDtoList.add(financeDto);
        }
        return financeDtoList;
    }
}
