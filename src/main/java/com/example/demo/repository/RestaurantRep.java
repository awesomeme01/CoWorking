package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRep  extends JpaRepository<Restaurant,Long> {

}
