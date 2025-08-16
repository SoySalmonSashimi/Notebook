package com.example.Notebook.Service;


import com.example.Notebook.Entity.TradeLog;
import com.example.Notebook.Repository.TradeImageRepository;
import com.example.Notebook.Repository.TradeLogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TradeImageService {
    private final TradeImageRepository tradeImageRepository;;
    private final TradeLogRepository tradeLogRepository;


    public TradeImageService(TradeImageRepository tradeImageRepository,TradeLogRepository tradeLogRepository)
    {
        this.tradeImageRepository = tradeImageRepository;
        this.tradeLogRepository = tradeLogRepository;

    }

    @Transactional
    public void addImageToUserTradingLog(long userId,long tradeLogId, MultipartFile file)
    {

    }

    @Transactional(readOnly = true)
    private TradeLog getTradingLogsForUser(Long userId, Long tradeLogId)
    {

        return tradeLogRepository.findByIdAndUserId(tradeLogId, userId)
                .orElseThrow(() -> new EntityNotFoundException("Trading log not found for user " + userId));

    }


}
