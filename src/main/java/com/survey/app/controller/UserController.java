package com.survey.app.controller;

import com.survey.app.model.User;
import com.survey.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody  User user){
        return userService.addUser(user);
    }


    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    
}
