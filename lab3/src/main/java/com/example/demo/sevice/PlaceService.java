package com.example.demo.sevice;

import com.example.demo.model.domain.Place;
import com.example.demo.repository.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    public void add(Place place){
        placeRepository.saveAndFlush(place);
    }

    public Place findById(Long id) throws Exception {
        return placeRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(Long id){
        placeRepository.deleteById(id);
    }

    public void setPlaceNumber(String id, String newNumber){
        placeRepository.setPlaceNumber(Long.parseLong(id), Integer.parseInt(newNumber));
    }
}
