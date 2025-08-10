package com.example.Notebook.Utils;

import com.example.Notebook.Dto.TradeLogDto;
import com.example.Notebook.Entity.TradeLog;


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
        tradeLogDto.setData(tradeLog.getData());
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
        tradeLog.setData(tradeLogDto.getData());
        return tradeLog;
    }
}
