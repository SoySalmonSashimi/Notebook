package com.example.Notebook.Controller;

import com.example.Notebook.Dto.NoteDto;
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
    public void createNoteById(@PathVariable long id, @RequestBody NoteDto noteDto)
    {
        noteService.generateNewNote(id,noteDto);
    }

    /**
     * Get All Note from UserID by ID
     * @param id
     * @return
     */
    @GetMapping("/AllNotes/{id}")
    public List<NoteDto> getAllNotesByUserId(@PathVariable long id)
    {
        return noteService.viewAllNotesByUser(id);
    }

    /**
     *  Find Note By Note ID and delete note
     */
    @DeleteMapping("/DeleteNote/{id}")
    public void deleteNoteById(@PathVariable long id)
    {
        noteService.deleteNoteByID(id);
    }


}
