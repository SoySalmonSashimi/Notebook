package com.example.Notebook.Controller;

import com.example.Notebook.Service.TradeImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequestMapping("/user")
public class TradeImageController {


    private final TradeImageService tradeImageService;

    public TradeImageController(TradeImageService tradeImageService)
    {

        this.tradeImageService = tradeImageService;
    }


    @PostMapping("/{userId}/tradinglog/{tradingLogId}/images")
    public ResponseEntity<String> uploadImage(@PathVariable long userId, @PathVariable long tradingLogId, @RequestParam("file") MultipartFile file) {

        tradeImageService.addImageToUserTradingLog(userId, tradingLogId, file);
        return ResponseEntity.ok("Image uploaded successfully");
    }
}
