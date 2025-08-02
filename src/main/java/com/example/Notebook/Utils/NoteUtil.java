package com.example.Notebook.Utils;

import com.example.Notebook.DTO.NoteDto;
import com.example.Notebook.Entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteUtil {


    public static List<NoteDto> toDtoList(List<Note> listOfNotes)
    {
        List<NoteDto> newListDto = new ArrayList<>();

        for(Note note: listOfNotes)
        {
            NoteDto newNote = new NoteDto();
            newNote.setNoteID(note.getNoteID());
            newNote.setCreatedDate(note.getCreatedDate());
            newNote.setTitle(note.getTitle());
            newNote.setContent(note.getContent());
            newNote.setCompletionStatus(note.isCompletionStatus());
            newListDto.add(newNote);
        }
        return newListDto;
    }
    public static NoteDto toDto(Note note)
    {
        NoteDto noteDto = new NoteDto();
        noteDto.setCompletionStatus(note.isCompletionStatus());
        noteDto.setNoteID(note.getNoteID());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        noteDto.setCreatedDate(note.getCreatedDate());
        return noteDto;
    }
    public static Note fromDto(NoteDto noteDto)
    {
        Note note = new Note();
        note.setCompletionStatus(noteDto.isCompletionStatus());
        note.setNoteID(noteDto.getNoteID());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setCreatedDate(noteDto.getCreatedDate());
        return note;
    }
}
