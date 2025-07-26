package com.example.Notebook.Controller;


import com.example.Notebook.Entity.User;
import com.example.Notebook.Service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * Declaration of Rest Controller Layer
 */
@RestController
@RequestMapping("/Account")
public class UserController {


    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    /**
     * Post Mapping To Create User By Taking Json Format in
     */
    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user)
    {

        return service.CreateNewUser(user);


    }
}
