package com.example.Notebook.Repository;

import com.example.Notebook.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NoteRepository extends JpaRepository<Note,Long> {

    @Query("SELECT n FROM Note n WHERE n.user.userId = :userId") // JPQL
    List<Note> findAllNoteByUserId(Long userId);
}
