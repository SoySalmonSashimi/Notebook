package com.example.Notebook.Repository;

import com.example.Notebook.Entity.TradeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TradeLogRepository extends JpaRepository<TradeLog,Long> {

    Optional<TradeLog> findByTradeIdAndUserUserId(Long tradeId, Long userId);
}
