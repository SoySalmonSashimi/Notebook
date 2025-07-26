package com.example.Notebook.Controller;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Service.UserService;
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
    private final UserService service;

    /**
     * Dependency Injection
     * @param service
     */
    public UserController(UserService service) {
        this.service = service;
    }


    /**
     * Get Mapping Request to retrieve data from database
     * @GetMapping http://localhost:8080/User/{SpecifyID}
     * @PathVariable is used to extract id value for query in service
     * @param id
     * @return User
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id)
    {
        return service.getUserById(id);
    }

    /**
     * @GetMapping request to retrieve all users from database
     * http://localhost:8080/User/getAllUsers
     *
     */
    @GetMapping("/getAllUsers")
    public List<User> getAllUser()
    {
        return service.getAllUsers();
    }


    /**
     *
     * @PostMapping is used to create user
     * @RequestBody converts request in json format into user entity
     * Calls into service layer to create entity
     * http://localhost:8080/User/CreateUser
     */
    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user)
    {

        return service.CreateNewUser(user);

    }
    /**
     * Update database user by ID
     *
     */

    @PutMapping("/UpdateUser/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User updateUserDetails)
    {
        service.UpdateUser(id,updateUserDetails);
    }



}
