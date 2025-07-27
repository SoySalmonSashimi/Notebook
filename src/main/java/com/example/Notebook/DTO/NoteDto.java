package com.example.Notebook.DTO;
import com.example.Notebook.Entity.User;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class NoteDto {

    long noteID;
    String title;
    String content;
    LocalDateTime createdDate;
    boolean status;
    private User user;

}

