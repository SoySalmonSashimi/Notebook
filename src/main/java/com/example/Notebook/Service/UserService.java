package com.example.Notebook.Service;

import com.example.Notebook.Dto.UserDto;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.UserRepository;
import com.example.Notebook.Utils.UserUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param userDto
     * @return
     */
    public User CreateNewUser(UserDto userDto)
    {
        return userRepository.save(UserUtil.fromDto(userDto));
    }

    /**
     *  Getting user by passing id
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public User getUserById(long id)
    {
        return userRepository.findById(id).orElse(null);
    }


    /**
     * Getting all users that are currently in database
     * @ return list of users
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    /**
     *  Update user by passing in user object and replacing with current user in database
     */
    @Transactional
    public void UpdateUser(long id, UserDto userDto)
    {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

        existingUser.setName(userDto.getName());
        existingUser.setAge(userDto.getAge());
        existingUser.setJobTitle(userDto.getJobTitle());
        existingUser.setContactNumber(userDto.getContactNumber());
        existingUser.setBirthday(userDto.getBirthday());
        existingUser.setAddress(userDto.getAddress());
        existingUser.setListOfNotes(userDto.getListOfNotes());
        existingUser.setListOfFinanceTrackingActivities(userDto.getListOfFinanceTrackingActivities());
        existingUser.setListOfSportActivities(userDto.getListOfSportActivities());
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
