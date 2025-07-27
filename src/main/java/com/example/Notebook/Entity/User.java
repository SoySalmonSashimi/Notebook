package com.example.Notebook.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
        String email;
        String address;
        String gender;
        int income;
        int dependency;
        String country;
        int contactNumber;
        LocalDate birthday;
        double height;
        double weight;
        @Column(name = "job_title") // Make sure it matches the column in DB
        String jobTitle;

        @OneToMany(mappedBy = "user")
        List<Note> listOfNotes;

}
