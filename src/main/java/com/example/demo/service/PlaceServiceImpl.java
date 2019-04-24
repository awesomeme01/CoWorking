package com.example.demo.service;

import com.example.demo.model.Place;
import com.example.demo.repository.PlaceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRep placeRep;

    @Override
    public List<Place> getAllPlaces(){
        return this.placeRep.findAll();
    }
    @Override
    public void deletePlaceById(Long id) {
        placeRep.deleteById(id);
    }
    @Override
    public Place getPlaceById(Long id) {
        return this.placeRep.findById(id).get();
    }
    @Override
    public Place savePlace(Place r) {
         return this.placeRep.save(r);
    }
}
