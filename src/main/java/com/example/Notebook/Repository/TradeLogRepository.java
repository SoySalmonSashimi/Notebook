package com.example.Notebook.Repository;

import com.example.Notebook.Entity.TradeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeLogRepository extends JpaRepository<TradeLog,Long> {
}
