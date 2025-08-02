package com.example.Notebook.Repository;

import com.example.Notebook.Entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance,Long> {
    List<Finance> findByUserUserId(Long userId);
}
