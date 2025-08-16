package com.example.Notebook.Utils;


import com.example.Notebook.Dto.TradeImageDto;
import com.example.Notebook.Entity.TradeImage;

public class TradeImageUtil {

    public static TradeImageDto toDto(TradeImage tradeImage)
    {
        TradeImageDto tradeImageDto = new TradeImageDto();
        tradeImageDto.setId(tradeImage.getId());
        tradeImageDto.setData(tradeImage.getData());
        tradeImageDto.setFilename(tradeImage.getFilename());

        return tradeImageDto;

    }
    public static TradeImage fromDto(TradeImageDto tradeImageDto)
    {
        TradeImage tradeImage = new TradeImage();
        tradeImage.setId(tradeImageDto.getId());
        tradeImage.setData(tradeImageDto.getData());
        tradeImage.setFilename(tradeImageDto.getFilename());

        return tradeImage;
    }
}
