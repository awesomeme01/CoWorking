package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRep userRep;
    @Override
    public User getUser(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRep.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRep.deleteById(id);
    }
}
