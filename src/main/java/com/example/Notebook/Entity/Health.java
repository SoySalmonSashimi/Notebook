package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long healthId;
    private double height;
    private double weight;
    private String sportsName;
    private double distance;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
