package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noteid")
    long noteID;
    String title;
    String content;
    @Column(name = "created_date")
    LocalDateTime createdDate;
    @Column(name = "completion_status")
    boolean completionStatus;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
