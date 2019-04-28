package com.example.demo.service;

import com.example.demo.enums.Categories;
import com.example.demo.model.Place;
import com.example.demo.repository.PlaceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<Place> getByCategory(Integer categoryId){
        //   1 EDUCATIONAL,
        //   2 ENTERTAINMENT,
        //   3 RESTAURANT,
        //   4 FASTFOOD,
        //   5 BANQUET_HALL,
        //   6 SPORT_FACILITY,
        //   7 SHOPPING;
        return this.placeRep.findAll().stream().filter(x -> x.getCategory().equals(getCategory(categoryId))).collect(Collectors.toList());

    }

    @Override
    public String getCategory(int id) {
        switch (id){
            case (1):
                return "EDUCATIONAL";
            case (2):
                return "ENTERTAINMENT";
            case (3):
                return "RESTAURANT";
            case (4):
                return "FASTFOOD";
            case (5):
                return "BANQUET_HALL";
            case (6):
                return "SPORT_FACILITY";
            case (7):
                return "SHOPPING";
            default:
                return null;
        }
    }
}
