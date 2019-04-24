package com.example.demo.repository;

import com.example.demo.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRep extends JpaRepository<Place,Long> {

}
