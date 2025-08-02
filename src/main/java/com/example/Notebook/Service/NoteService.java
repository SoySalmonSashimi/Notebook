package com.example.Notebook.Service;

import com.example.Notebook.DTO.NoteDto;
import com.example.Notebook.Entity.Note;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.NoteRepository;
import com.example.Notebook.Repository.UserRepository;
import com.example.Notebook.Utils.NoteUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public void generateNewNote(long id,NoteDto noteDto)
    {
        User user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found with id " + id));
        Note note = NoteUtil.fromDto(noteDto);
        note.setCreatedDate(LocalDateTime.now());
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
       return NoteUtil.toDtoList(listOfNotes);
    }

}
