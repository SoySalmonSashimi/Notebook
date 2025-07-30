package com.example.Notebook.Repository;

import com.example.Notebook.Entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRepository extends JpaRepository<Health,Long> {
    List<Health> findByUserUserId(Long userId);
}
