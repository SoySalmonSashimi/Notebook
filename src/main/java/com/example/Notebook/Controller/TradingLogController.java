package com.example.Notebook.Controller;

import com.example.Notebook.Dto.TradeLogDto;
import com.example.Notebook.Service.TradeLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tradelog")
public class TradingLogController {

    private final TradeLogService tradeLogService;

    public TradingLogController(TradeLogService tradeLogService)
    {
        this.tradeLogService = tradeLogService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Void> createTradeLogActivities(@PathVariable long userId, @RequestBody TradeLogDto tradeLogDto)
    {
            tradeLogService.createNewTradingActivity(userId,tradeLogDto);

         return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("user/{userId}/All")
    public ResponseEntity<List<TradeLogDto>> getAllActivityByUserId(@PathVariable long userId)
    {
           List<TradeLogDto> listOfTradeLogByUser =  tradeLogService.getAllTradeActivities(userId);
         return ResponseEntity.ok(listOfTradeLogByUser);
    }


}
