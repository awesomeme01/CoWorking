package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestaurantController.url)
public class RestaurantController  {
    public static final String url = "/api/restaurants";

    //    List<Restaurant> getAllRestaurants();
    //    Restaurant getRestaurantById(Long id);
    //    void saveRestaurant(Restaurant r);
    //    void deleteRestaurantById(Long id);
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Restaurant getById(@PathVariable  Long id){
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Restaurant create(@RequestBody Restaurant restaurant){
        return restaurantService.saveRestaurant(restaurant);
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable Long id){
        restaurantService.deleteRestaurantById(id);
    }

}
