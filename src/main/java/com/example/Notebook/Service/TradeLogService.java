package com.example.Notebook.Service;

import com.example.Notebook.Dto.TradeLogDto;
import com.example.Notebook.Entity.TradeLog;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.TradeImageRepository;
import com.example.Notebook.Repository.TradeLogRepository;
import com.example.Notebook.Repository.UserRepository;
import com.example.Notebook.Utils.TradeLogUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TradeLogService {
    private final TradeLogRepository tradeLogRepository;
    private final UserRepository userRepository;

    public TradeLogService(TradeLogRepository tradeLogRepository,UserRepository userRepository)
    {

        this.tradeLogRepository = tradeLogRepository;
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = false)
    public TradeLogDto createNewTradingActivity(long userId, TradeLogDto tradeLogDto)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User id not found" + userId));
        TradeLog tradeLog = TradeLogUtil.fromDto(tradeLogDto);
        tradeLog.setUser(user);
        TradeLog savedLog = tradeLogRepository.save(tradeLog);
        return TradeLogUtil.toDto(savedLog);
    }

    @Transactional(readOnly = true)
    public List<TradeLogDto> getAllTradeActivities(long userId)
    {
         List<TradeLog> listOfTradeLog =  userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException("User not found " + userId)).getListOfTradingLogsActivities();
         return TradeLogUtil.listToDto(listOfTradeLog);

    }


}
