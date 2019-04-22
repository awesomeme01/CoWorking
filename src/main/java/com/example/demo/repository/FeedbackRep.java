package com.example.demo.repository;

import com.example.demo.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRep extends JpaRepository<Feedback, Long> {
}
