package com.example.demo.service;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl  implements  RestaurantService{
    @Autowired
    private RestaurantRep restaurantRep;

    @Override
    public List<Restaurant> getAllRestaurants(){
        return this.restaurantRep.findAll();
    }
    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRep.deleteById(id);
    }
    @Override
    public  Restaurant getRestaurantById(Long id) {
        return this.restaurantRep.findById(id).get();
    }
    @Override
    public Restaurant saveRestaurant(Restaurant r) {
         return this.restaurantRep.save(r);
    }
}
