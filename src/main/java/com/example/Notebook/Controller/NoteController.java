package com.example.Notebook.Controller;

import com.example.Notebook.Entity.Note;
import com.example.Notebook.Service.NoteService;
import com.example.Notebook.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Note")
public class NoteController {
    private final UserService userService;
    private final NoteService noteService;


    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
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


}
