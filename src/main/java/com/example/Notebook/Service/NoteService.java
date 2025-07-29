package com.example.Notebook.Service;

import com.example.Notebook.DTO.NoteDto;
import com.example.Notebook.Entity.Note;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.NoteRepository;
import com.example.Notebook.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @Transactional
    public void deleteNoteByID(long noteID)
    {
        noteRepository.deleteById(noteID);
    }

    @Transactional(readOnly = true)
    public List<NoteDto> viewAllNotesByUser(long userId) {
       List<Note> listOfNotes= noteRepository.findAllNoteByUserId(userId);
       List<NoteDto> newListDto = new ArrayList<>();

       for(Note note: listOfNotes)
       {
           NoteDto newNote = new NoteDto();
          newNote.setNoteID(note.getNoteID());
          newNote.setCreatedDate(note.getCreatedDate());
          newNote.setTitle(note.getTitle());
          newNote.setContent(note.getContent());
          newNote.setStatus(note.isCompletionStatus());
          newListDto.add(newNote);
       }
       return newListDto;
    }
}
