package com.example.demo.service;

import com.example.demo.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedBackById(Long id);
    List<Feedback> getFeedBackByPlace(Long id);
    void deleteFeedback(Long id);
}
