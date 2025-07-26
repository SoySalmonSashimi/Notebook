package com.example.Notebook.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user") // Ensure table name matches MySQL exactly
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id") // Make sure it matches the column in DB
        long userId;
        String name;
        int age;
        @Column(name = "job_title") // Make sure it matches the column in DB
        String jobTitle;


}
