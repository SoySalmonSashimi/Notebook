package com.example.Notebook.Service;

import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    /**
     *  Update user by passing in user object and replacing with current user in database
     */
    @Transactional
    public void UpdateUser(long id, User userData)
    {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

        existingUser.setName(userData.getName());
        existingUser.setAge(userData.getAge());
        existingUser.setJobTitle(userData.getJobTitle());

    }

    /***
     *  Delete User by id number
     */
    @Transactional
    public void deleteUser(long userId)
    {
        userRepository.deleteById(userId);


    }



}
