package com.example.Notebook.DTO;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class NoteDto {

    long noteID;
    String title;
    String content;
    LocalDateTime createdDate;
    boolean status;

    public NoteDto() {

    }
    public NoteDto(long noteID, String title, String content, LocalDateTime createdDate, boolean status) {
        this.noteID = noteID;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.status = status;
    }


}

