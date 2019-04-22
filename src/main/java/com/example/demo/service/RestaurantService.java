package com.example.demo.service;


import com.example.demo.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);
    Restaurant saveRestaurant(Restaurant r);
    void deleteRestaurantById(Long id);
}
