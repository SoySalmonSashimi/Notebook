package com.example.Notebook.Service;

import com.example.Notebook.Dto.TradeLogDto;
import com.example.Notebook.Entity.TradeLog;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.TradeLogRepository;
import com.example.Notebook.Repository.UserRepository;
import com.example.Notebook.Utils.TradeLogUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TradeLogService {
    private final TradeLogRepository tradeLogRepository;
    private final UserRepository userRepository;

    public TradeLogService(TradeLogRepository tradeLogRepository,UserRepository userRepository)
    {
        this.tradeLogRepository = tradeLogRepository;
        this.userRepository = userRepository;
    }

    public TradeLogDto createNewTradingActivity(long userId, TradeLogDto tradeLogDto)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User id not found" + userId));
        TradeLog tradeLog = TradeLogUtil.fromDto(tradeLogDto);
        tradeLog.setUser(user);
        TradeLog savedLog = tradeLogRepository.save(tradeLog);
        return TradeLogUtil.toDto(savedLog);
    }
}
