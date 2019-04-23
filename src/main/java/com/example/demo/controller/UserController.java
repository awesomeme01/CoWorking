package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

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
    public Response getUser(@PathVariable Long id){
        return new Response(true, "Returned user with id = " + id ,userService.getUser(id));
    }

    @GetMapping(path = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getAll(){
        return new Response(true, "All users ever registered",userService.getAllUsers());
    }

    @PostMapping(path = "/create",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response createUser(@RequestBody User user){
        return new Response(true,"Created new user",userService.createUser(user));
    }

    @DeleteMapping(path = "/delete/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response deleteUser(@PathVariable Long id){

        userService.deleteUser(id);
        return new Response(true, "Deleted user with  id = " + id, null);
    }
}
