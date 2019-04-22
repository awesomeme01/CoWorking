package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.url)
public class UserController {
    public static final String url = "/api/users";
    //    User getUser(Long id);
    //    List<User> getAllUsers();
    //    User createUser(User user);
    //    void deleteUser(Long id);
    @Autowired
    private UserService userService;
    @GetMapping(path = "/get/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping(path = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/create",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(path = "/delete/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
