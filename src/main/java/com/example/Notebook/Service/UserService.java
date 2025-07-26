package com.example.Notebook.Service;

import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    /**
     * Instantiate User Repository
     */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *  Transactional TO Create User From Data provided in json format
     * @param user
     * @return
     */
    @Transactional
    public User CreateNewUser(User user)
    {
        return userRepository.save(user);
    }
}
