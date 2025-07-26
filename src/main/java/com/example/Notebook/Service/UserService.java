package com.example.Notebook.Service;

import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    /**
     * Instantiate User Repository
     */
    private final UserRepository userRepository;

    /**
     * Dependency Injection
     * @param userRepository
     */
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

    /**
     *  Getting user by passing id
     * @param id
     * @return
     */
    public User getUserById(long id)
    {
        return userRepository.findById(id).orElse(null);
    }


    /**
     * Getting all users that are currently in database
     * @ return list of users
     */
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

}
