package com.example.Notebook.Service;

import com.example.Notebook.Entity.Note;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.NoteRepository;
import com.example.Notebook.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void generateNewNote(long id,Note note)
    {
        User user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found with id " + id));
        LocalDateTime date = LocalDateTime.now();
        note.setCreatedDate(date);
        note.setUser(user);
        noteRepository.save(note);
    }
}
