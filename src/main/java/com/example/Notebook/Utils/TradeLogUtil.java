package com.example.Notebook.Utils;

import com.example.Notebook.Dto.TradeLogDto;
import com.example.Notebook.Entity.TradeLog;

import java.util.ArrayList;
import java.util.List;


public class TradeLogUtil {

    public static TradeLogDto toDto(TradeLog tradeLog)
    {
        TradeLogDto tradeLogDto = new TradeLogDto();
        tradeLogDto.setTradeId(tradeLog.getTradeId());
        tradeLogDto.setBroker(tradeLog.getBroker());
        tradeLogDto.setBalance(tradeLog.getBalance());
        tradeLogDto.setSymbol(tradeLog.getSymbol());
        tradeLogDto.setQuantity(tradeLog.getQuantity());
        tradeLogDto.setPnl(tradeLog.getPnl());
        tradeLogDto.setNotes(tradeLog.getNotes());

        return tradeLogDto;

    }

    public static TradeLog fromDto(TradeLogDto tradeLogDto)
    {
        TradeLog tradeLog = new TradeLog();
        tradeLog.setTradeId(tradeLogDto.getTradeId());
        tradeLog.setBroker(tradeLogDto.getBroker());
        tradeLog.setBalance(tradeLogDto.getBalance());
        tradeLog.setSymbol(tradeLogDto.getSymbol());
        tradeLog.setQuantity(tradeLogDto.getQuantity());
        tradeLog.setPnl(tradeLogDto.getPnl());
        tradeLog.setNotes(tradeLogDto.getNotes());

        return tradeLog;
    }

    public static List<TradeLogDto> listToDto(List<TradeLog> listOfTradeLog)
    {
         List<TradeLogDto> listOfTradeLogDto = new ArrayList<>();
         TradeLogDto tradeLogDto = null;
         for(TradeLog tradeLog : listOfTradeLog)
         {
             tradeLogDto = new TradeLogDto();
             tradeLogDto.setTradeId(tradeLog.getTradeId());
             tradeLogDto.setSymbol(tradeLog.getSymbol());
             tradeLogDto.setBroker(tradeLog.getBroker());
             tradeLogDto.setPnl(tradeLog.getPnl());
             tradeLogDto.setBalance(tradeLog.getBalance());
             tradeLogDto.setNotes(tradeLog.getNotes());
             listOfTradeLogDto.add(tradeLogDto);

         }
         return listOfTradeLogDto;
    }

    public static List<TradeLog> listFromDto(List<TradeLogDto> listOfTradeLogDto)
    {
        List<TradeLog> listOfTradeLog = new ArrayList<>();
        TradeLog tradeLog = null;
        for(TradeLog tradeLogDto : listOfTradeLog)
        {
            tradeLog = new TradeLog();
            tradeLog.setTradeId(tradeLogDto.getTradeId());
            tradeLog.setSymbol(tradeLogDto.getSymbol());
            tradeLog.setBroker(tradeLogDto.getBroker());
            tradeLog.setPnl(tradeLogDto.getPnl());
            tradeLog.setBalance(tradeLogDto.getBalance());
            tradeLog.setNotes(tradeLogDto.getNotes());
            listOfTradeLog.add(tradeLog);

        }
        return listOfTradeLog;

    }

}
