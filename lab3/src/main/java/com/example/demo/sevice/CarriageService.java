package com.example.demo.sevice;

import com.example.demo.model.domain.Carriage;
import com.example.demo.repository.CarriageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarriageService {

    private final CarriageRepository carriageRepository;

    public CarriageService(CarriageRepository carriageRepository) {
        this.carriageRepository = carriageRepository;
    }

    public void add (Carriage carriage){
        carriageRepository.saveAndFlush(carriage);
    }

    public Carriage findById(String id) throws Exception {
        return carriageRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(String id) {
        carriageRepository.deleteById(id);
    }

    public void setCarriageType(String id, String newType){
        carriageRepository.setCarriageType(id, newType);
    }

}
