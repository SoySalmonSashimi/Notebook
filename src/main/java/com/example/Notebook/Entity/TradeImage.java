package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TradeImage {
    // Declaration of image storage into mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
