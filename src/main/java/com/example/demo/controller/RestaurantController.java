package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")

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
    public Response getAllRestaurants(){
        return new Response(true, "All Restaurants ever registered",restaurantService.getAllRestaurants());
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable  Long id){
        try{
            return new Response(true,"Returned restaurant with id = " + id ,restaurantService.getRestaurantById(id));
        }
        catch (NoSuchElementException ex){
            System.out.println(ex);
            return new Response(false,"There is no any restaurant with id = " + id,null);
        }
    }

    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response create(@RequestBody Restaurant restaurant){
        return new Response(true,"Created new restaurant", restaurantService.saveRestaurant(restaurant));
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Response delete(@PathVariable Long id){
        restaurantService.deleteRestaurantById(id);
        return new Response(true, "Deleted restaurant with id = " + id ,null);
    }

}
