package com.example.Notebook.Repository;

import com.example.Notebook.Entity.TradeImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TradeImageRepository extends JpaRepository<TradeImage,Long> {

    Optional<TradeImage> findByImageIdAndTradeLogTradeIdAndTradeLogUserUserId(
            Long imageId, Long tradeLogId, Long userId);
}
