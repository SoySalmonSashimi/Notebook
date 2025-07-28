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
        private long userId;
        private String name;
        private int age;
        private String email;
        private String address;
        private String gender;
        private int income;
        private int dependency;
        private String country;
        private int contactNumber;
        private LocalDate birthday;
        private double height;
        private double weight;
        @Column(name = "job_title") // Make sure it matches the column in DB
        private String jobTitle;

        @OneToMany(mappedBy = "user")
        private List<Note> listOfNotes;

}
