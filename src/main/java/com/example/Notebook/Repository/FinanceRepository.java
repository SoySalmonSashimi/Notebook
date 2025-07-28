package com.example.Notebook.Repository;

import com.example.Notebook.Entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance,Long> {
}
