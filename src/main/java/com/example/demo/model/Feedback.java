package com.example.demo.model;

import com.example.demo.enums.FeedbackStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name= "feedback_1")
public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Integer rating;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User userId;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place placeId;
    private FeedbackStatus feedbackStatus;

    public Feedback() {
    }

    public Feedback(String message, Integer rating, User userId, Place placeId) {
        this.message = message;
        this.rating = rating;
        this.userId = userId;
        this.placeId = placeId;
    }

    public FeedbackStatus getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(FeedbackStatus feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Place placeId) {
        this.placeId = placeId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}