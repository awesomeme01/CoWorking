package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Feedback> getAll(){
        return feedbackService.getAllFeedbacks();
    }
    @GetMapping(path = "/get/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Feedback getById(@PathVariable Long id){
        return feedbackService.getFeedBackById(id);
    }
    @GetMapping(path = "/getByRestaurantId/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Feedback> getByRestaurantId(@PathVariable Long id){
        return feedbackService.getFeedBackByRestaurant(id);
    }
    @PostMapping(path = "/create",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }
    @DeleteMapping(path = "/delete/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public void deleteFeedback(@PathVariable Long id){
        feedbackService.deleteFeedback(id);
    }
}
