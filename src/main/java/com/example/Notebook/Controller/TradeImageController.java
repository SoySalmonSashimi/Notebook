package com.example.Notebook.Controller;

import com.example.Notebook.Entity.TradeImage;
import com.example.Notebook.Service.TradeImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class TradeImageController {


    private final TradeImageService tradeImageService;

    public TradeImageController(TradeImageService tradeImageService)
    {

        this.tradeImageService = tradeImageService;
    }


    @PostMapping("/{userId}/tradinglog/{tradingLogId}/images")
    public ResponseEntity<String> uploadImage(@PathVariable long userId, @PathVariable long tradingLogId, @RequestParam("file") MultipartFile file) throws IOException {

        tradeImageService.addImageToUserTradingLog(userId, tradingLogId, file);
        return ResponseEntity.ok("Image uploaded successfully");
    }


    @GetMapping("/users/{userId}/tradelogs/{tradeLogId}/images/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable long userId, @PathVariable long tradeLogId, @PathVariable long imageId) {

        TradeImage image = tradeImageService.getImagesForUserTradeLog(userId,tradeLogId,imageId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(image.getData());
    }
}
