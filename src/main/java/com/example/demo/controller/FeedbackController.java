package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.model.Response;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(FeedbackController.url)
public class FeedbackController {
    //    Feedback createFeedback(Feedback feedback);
    //    List<Feedback> getAllFeedbacks();
    //    Feedback getFeedBackById(Long id);
    //    List<Feedback> getFeedBackByRestaurant(Long id);
    //    void deleteFeedback(Long id);
    public static final String url = "/api/feedbacks";
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping(path = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getAll(){
        return new Response(true,"All feedbacks ever made!!!", feedbackService.getAllFeedbacks());
    }
    @GetMapping(path = "/get/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable Long id){
        if(id <=0){
            return new Response(false, "Id has to be greater than zero",null);
        }
        try{
            return new Response(true,"Returned feedback by id = " + id,feedbackService.getFeedBackById(id));
        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return new Response(false, "Feedback with id = " + id +" doesn't exist!!!",null);
        }
    }
    @GetMapping(path = "/getByRestaurantId/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getByRestaurantId(@PathVariable Long id){
        List<Feedback> feedbackList = feedbackService.getFeedBackByRestaurant(id);
        if(feedbackList.size() ==0){
            return new Response(true, "Feedbacks for this restaurant don't exist", null);
        }
        return new Response(true, "Returned feedbacks for the restaurant with id = " + id,feedbackList);
    }
    @PostMapping(path = "/create/{userId}/{restaurantId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response createFeedback(@RequestBody Feedback feedback,@PathVariable Long userId, @PathVariable Long restaurantId) {
        try {
            feedback.setRestaurantId(restaurantService.getRestaurantById(restaurantId));
            feedback.setUserId(userService.getUser(userId));
            if(feedback.getRating()<=0){
                return new Response(false, "Rating value has to be greater than zero", null);
            }
            return new Response(true, "Created new feedback", feedbackService.createFeedback(feedback));
        }
        catch (NoSuchElementException ex){
            return new Response(false, "Couldn't create feedback. Error finding user or restaurant by their IDs",null);
        }
    }
    @DeleteMapping(path = "/delete/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response deleteFeedback(@PathVariable Long id){
        try {
            feedbackService.deleteFeedback(id);
            return new Response(true, "Deleted feedback with id = "+ id, null);
        }
        catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return new Response(false, "There is no such feedback with id = " + id ,null);
        }

    }
}
