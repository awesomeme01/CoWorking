package com.example.demo.bootstrap;

import com.example.demo.enums.Status;
import com.example.demo.model.Feedback;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestaurantBootstrap implements CommandLineRunner {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    UserService userService;

    @Override
    public void run(String ... args)throws  Exception{
        //User(String fullname, String nickname, int age, Status status, Boolean isActive)
        User user1 = new User("Shabdan Medet uulu", "awesomeme01",17, Status.ACTIVE,true);
        //Restaurant(String name, String address)
        Restaurant restaurant1 = new Restaurant("Ak Saray","Ankara Street");
        //Feedback(String message, Integer rating, User userId, Restaurant restaurantId)
        Feedback feedback = new Feedback("Крутой ресторан!!!", 6, user1,restaurant1);
        userService.createUser(user1);
        restaurantService.saveRestaurant(restaurant1);
        feedbackService.createFeedback(feedback);

    }
}
