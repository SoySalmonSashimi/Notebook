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
        private String emailAddress;
        private String address;
        private String gender;
        private String country;
        private long contactNumber;
        private LocalDate birthday;

        @Column(name = "job_title") // Make sure it matches the column in DB
        private String jobTitle;
        /**
         *  Each user can have many notes
         */
        @OneToMany(mappedBy = "user")
        private List<Note> listOfNotes;

        /**
         * Each user can have many sports activities
         */
        @OneToMany(mappedBy = "user")
        private List<Health> listOfSportActivities;

        /**
         * Each user can have multiple finance report entry by Monthly
         */
        @OneToMany(mappedBy ="user")
        private List<Finance> listOfFinanceTrackingActivities;


}
