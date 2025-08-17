package com.example.Notebook.Service;


import com.example.Notebook.Entity.TradeImage;
import com.example.Notebook.Entity.TradeLog;
import com.example.Notebook.Repository.TradeImageRepository;
import com.example.Notebook.Repository.TradeLogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

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
    public void addImageToUserTradingLog(long userId,long tradeLogId, MultipartFile file) throws IOException
    {

        TradeLog tradelog = tradeLogRepository.findByTradeIdAndUserUserId(tradeLogId,userId).orElseThrow(()-> new EntityNotFoundException("User ID / TradeLogID Not found "));
        TradeImage tradeImage = new TradeImage();
        tradeImage.setTradeLog(tradelog);
        tradeImage.setFilename(file.getOriginalFilename());
        tradeImage.setData(file.getBytes());
        tradeImageRepository.save(tradeImage);


    }
    @Transactional
    public TradeImage getImagesForUserTradeLog(long userId, long tradeLogId, long imageId) {
        List<TradeImage> listOfTradeImage = tradeLogRepository.findByTradeIdAndUserUserId(tradeLogId,userId).orElseThrow(()-> new EntityNotFoundException("User ID / TradeLogID Not found ")).getListOfImages();
        TradeImage tradeImage = new TradeImage();
        for(TradeImage image: listOfTradeImage)
        {
            if(image.getImageId() == imageId)
            {
                tradeImage = image;
            }
            else image = null;
        }

        return tradeImage;
    }

    @Transactional(readOnly = true)
    private TradeLog getTradingLogsForUser(Long userId, Long tradeLogId)
    {

        return tradeLogRepository.findByTradeIdAndUserUserId(tradeLogId, userId)
                .orElseThrow(() -> new EntityNotFoundException("Trading log not found for user " + userId));

    }


}
