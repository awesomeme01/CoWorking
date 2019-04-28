package com.example.demo.bootstrap;

import com.example.demo.enums.Categories;
import com.example.demo.enums.UserStatus;
import com.example.demo.model.Feedback;
import com.example.demo.model.Place;
import com.example.demo.model.User;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.PlaceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlaceBootstrap implements CommandLineRunner {
    @Autowired
    PlaceService placeService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    UserService userService;

    @Override
    public void run(String ... args)throws  Exception{
        //User(String fullname, String nickname, int age, UserStatus status, Boolean isActive)
//        User user1 = new User("Shabdan Medet uulu", "awesomeme01",17, UserStatus.ACTIVE);
//        //Place(String name, String address)
//        Place place1 = new Place("Ak Saray","Ankara Street", Categories.RESTAURANT);
//        //Feedback(String message, Integer rating, User userId, Place placeId)
//        Feedback feedback = new Feedback("Крутой ресторан!!!", 6, user1, place1);
//        userService.createUser(user1);
//        placeService.savePlace(place1);
//        feedbackService.createFeedback(feedback);

    }
}
