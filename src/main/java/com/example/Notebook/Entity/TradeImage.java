package com.example.Notebook.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "trade_image")
public class TradeImage {
    // Declaration of image storage into mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageId" )
    private Long imageId;

    private String filename;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "trade_id")
    private TradeLog tradeLog;

}
