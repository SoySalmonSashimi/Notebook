package com.example.Notebook.Repository;

import com.example.Notebook.Entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Health,Long> {
}
