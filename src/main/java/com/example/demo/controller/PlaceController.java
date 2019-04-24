package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.Place;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(PlaceController.url)
public class PlaceController {
    public static final String url = "/api/places";

    //    List<Place> getAllPlace();
    //    Place getPlaceById(Long id);
    //    void savePlace(Place r);
    //    void deletePlaceById(Long id);
    @Autowired
    private PlaceService placeService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getAllPlaces(){
        return new Response(true, "All Place ever registered", placeService.getAllPlaces());
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable  Long id){
        try{
            return new Response(true,"Returned Place with id = " + id , placeService.getPlaceById(id));
        }
        catch (NoSuchElementException ex){
            System.out.println(ex);
            return new Response(false,"There is no any Place with id = " + id,null);
        }
    }

    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response create(@RequestBody Place place){
        return new Response(true,"Created new Place", placeService.savePlace(place));
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Response delete(@PathVariable Long id){
        placeService.deletePlaceById(id);
        return new Response(true, "Deleted Place with id = " + id ,null);
    }

}
