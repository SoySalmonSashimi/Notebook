package com.example.Notebook.Service;

import com.example.Notebook.Dto.NoteDto;
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
    public NoteDto generateNewNote(long userId,NoteDto noteDto)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User not found with id " + userId));
        Note note = NoteUtil.fromDto(noteDto);
        note.setCreatedDate(LocalDateTime.now());
        note.setUser(user);
        Note saved = noteRepository.save(note);
        return NoteUtil.toDto(saved);
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
