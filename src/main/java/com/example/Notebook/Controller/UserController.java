package com.example.Notebook.Controller;
import com.example.Notebook.Dto.UserDto;
import com.example.Notebook.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Declaration of RestController Layer
 */
@RestController
@RequestMapping("/User")
public class UserController {

    /**
     *
     *  Instantiation of Service Layer
     */
    private final UserService userService;

    /**
     * Dependency Injection
     * @param userService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Get Mapping Request to retrieve data from database
     * @GetMapping http://localhost:8080/User/{SpecifyID}
     * @PathVariable is used to extract id value for query in service
     * @param userId
     * @return User
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long userId)
    {
        UserDto userDto =  userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    /**
     * @GetMapping request to retrieve all users from database
     * http://localhost:8080/User/getAllUsers
     *
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        List<UserDto> listOfUser = userService.getAllUsers();
        return ResponseEntity.ok(listOfUser);
    }


    /**
     *
     * @PostMapping is used to create user
     * @RequestBody converts request in json format into user entity
     * Calls into service layer to create entity
     * http://localhost:8080/User/CreateUser
     */
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto)
    {
          userService.CreateNewUser(userDto);
          return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * Update database user by ID
     *
     */

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long userId, @RequestBody UserDto userDto)
    {
        UserDto updatedUser = userService.UpdateUser(userId,userDto);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Deleting User By ID
     *
     * @param userId
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId)
    {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
    }



}
