package com.example.Notebook.Service;

import com.example.Notebook.Repository.NoteRepository;
import com.example.Notebook.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    /**
     *  Instantiation of repository
     */
    private final UserRepository userInformation;
    private final NoteRepository noteInformation;

    /**
     * Dependencies injection
     * @param userInformation
     * @param noteInformation
     */
    public UserDetailsService(UserRepository userInformation, NoteRepository noteInformation) {
        this.userInformation = userInformation;
        this.noteInformation = noteInformation;
    }



}
