package com.example.Notebook.Controller;

import com.example.Notebook.Dto.NoteDto;
import com.example.Notebook.Service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     *  Create Note For User by user ID
     */
    @PostMapping("/user/{userId}")
    public ResponseEntity<Void> createNoteById(@PathVariable long userId, @RequestBody NoteDto noteDto)
    {
        NoteDto saved = noteService.generateNewNote(userId,noteDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Get All Note from UserID by ID
     * @param userId
     * @return
     */
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<NoteDto>> getAllNotesByUserId(@PathVariable long userId)
    {

        List<NoteDto> listOfNotes = noteService.viewAllNotesByUser(userId);
        return ResponseEntity.ok(listOfNotes);
    }

    /**
     *  Find Note By Note ID and delete note
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable long userId)
    {
        noteService.deleteNoteByID(userId);
        return ResponseEntity.noContent().build();
    }


}
