package com.example.demo.service;

import com.example.demo.model.Feedback;
import com.example.demo.model.Place;
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
    private PlaceService placeService;
    @Override
    public synchronized Feedback createFeedback(Feedback feedback) {
        Place place = placeService.getPlaceById(feedback.getPlaceId().getId());
        if(place.getRating()!=null) {
            place.setRating(Math.round((place.getRating() + feedback.getRating()) / (place.getRatingCount() + 1)));
        }else{
            place.setRating(feedback.getRating());
        }
        if (place.getRatingCount()!=null){
            place.setRatingCount(place.getRatingCount()+1);
        }else{
            place.setRatingCount(1);
        }
        placeService.savePlace(place);
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
    public List<Feedback> getFeedBackByPlace(Long placeId) {
        return feedbackRep.findAll().stream().filter(x->x.getPlaceId().getId().equals(placeId)).collect(Collectors.toList());
    }

    @Override
    public synchronized void deleteFeedback(Long id ) {
        Feedback feedback = feedbackRep.findById(id).get();
        feedbackRep.deleteById(id);
        Place place = placeService.getPlaceById(feedback.getPlaceId().getId());
        Integer sum = 0;
        List<Feedback> feedbackList = this.getFeedBackByPlace(place.getId());
        feedbackList.stream().forEach(x->sum.equals(x.getRating() + sum));
        place.setRating(Math.round(sum/(place.getRatingCount() -1)));
        placeService.savePlace(place);
    }
}
