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
    @Transactional
    public void CreateNewUser(UserDto userDto)
    {
        User user = UserUtil.fromDto(userDto);
         User saved = userRepository.save(user);

    }

    /**
     *  Getting user by passing id
     * @param userId
     * @return
     */
    @Transactional(readOnly = true)
    public UserDto getUserById(long userId)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User Not Found By " + userId) );
        return UserUtil.toDto(user);
    }


    /**
     * Getting all users that are currently in database
     * @ return list of users
     */
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers()
    {
        List<User> listOfUser = userRepository.findAll();

        return UserUtil.toDtoList(listOfUser);
    }

    /**
     *  Update user by passing in user object and replacing with current user in database
     */
    @Transactional
    public UserDto UpdateUser(long userId, UserDto userDto)
    {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));

         UserUtil.updateUserFromDto(existingUser,userDto);
         return UserUtil.toDto(existingUser);
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
