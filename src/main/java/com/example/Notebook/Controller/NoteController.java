package com.example.Notebook.Controller;

import com.example.Notebook.DTO.NoteDto;
import com.example.Notebook.Entity.Note;
import com.example.Notebook.Service.NoteService;
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
    @PostMapping("/CreateNote/{id}")
    public void createNoteById(@PathVariable long id, @RequestBody Note note)
    {
        noteService.generateNewNote(id,note);
    }

    @GetMapping("/AllNotes/{id}")
    public List<NoteDto> getAllNotesByUserId(@PathVariable long id)
    {
        return noteService.viewAllNotesByUser(id);
    }
}
