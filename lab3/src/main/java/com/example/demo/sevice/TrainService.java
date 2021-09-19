package com.example.demo.sevice;

import com.example.demo.model.domain.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void add(Train train){
        trainRepository.saveAndFlush(train);
    }

    public Train findById(String id) throws Exception {
        return trainRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(String id){
        trainRepository.deleteById(id);
    }

    public void setTrainMaxCarriage(String id, String maxCarriage){
        trainRepository.setTrainMaxCarriage(id, Integer.parseInt(maxCarriage));
    }
}
