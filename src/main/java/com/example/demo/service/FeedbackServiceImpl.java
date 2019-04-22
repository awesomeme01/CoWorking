package com.example.demo.service;

import com.example.demo.model.Feedback;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.FeedbackRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRep feedbackRep;
    @Autowired
    private RestaurantService restaurantService;
    @Override
    public synchronized Feedback createFeedback(Feedback feedback) {
        Restaurant restaurant = restaurantService.getRestaurantById(feedback.getRestaurantId().getId());
        if(restaurant.getRating()!=null) {
            restaurant.setRating(Math.round((restaurant.getRating() + feedback.getRating()) / (restaurant.getRatingCount() + 1)));
        }else{
            restaurant.setRating(feedback.getRating());
        }
        if (restaurant.getRatingCount()!=null){restaurant.setRatingCount(restaurant.getRatingCount()+1);
        }else{
            restaurant.setRatingCount(1);
        }
        restaurantService.saveRestaurant(restaurant);
        return feedbackRep.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRep.findAll();
    }

    @Override
    public Feedback getFeedBackById(Long id) {
        return feedbackRep.findById(id).get();
    }

    @Override
    public List<Feedback> getFeedBackByRestaurant(Long restaurantId) {
        return feedbackRep.findAll().stream().filter(x->x.getRestaurantId().getId().equals(restaurantId)).collect(Collectors.toList());
    }

    @Override
    public synchronized void deleteFeedback(Long id ) {
        Feedback feedback = feedbackRep.findById(id).get();
        feedbackRep.deleteById(id);
        Restaurant restaurant = restaurantService.getRestaurantById(feedback.getRestaurantId().getId());
        Integer sum = 0;
        List<Feedback> feedbackList = this.getFeedBackByRestaurant(restaurant.getId());
        feedbackList.stream().forEach(x->sum.equals(x.getRating() + sum));
        restaurant.setRating(Math.round(sum/(restaurant.getRatingCount() -1)));
        restaurantService.saveRestaurant(restaurant);
    }
}
