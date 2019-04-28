package com.example.demo.service;


import com.example.demo.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceById(Long id);
    Place savePlace(Place r);
    void deletePlaceById(Long id);
    List<Place> getByCategory(Integer categoryId);
    String getCategory(int id);
}
