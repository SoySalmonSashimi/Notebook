package com.example.Notebook.Dto;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class NoteDto {

    private long noteID;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private boolean completionStatus;

    public NoteDto() {

    }
    public NoteDto(long noteID, String title, String content, LocalDateTime createdDate, boolean completionStatus) {
        this.noteID = noteID;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.completionStatus = completionStatus;
    }


}

