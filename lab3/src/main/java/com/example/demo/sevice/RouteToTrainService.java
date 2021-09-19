package com.example.demo.sevice;

import com.example.demo.model.domain.RouteToTrainTimeTable;
import com.example.demo.repository.RouteToTrainRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RouteToTrainService {
    private final RouteToTrainRepository routeToTrainRepository;

    public RouteToTrainService(RouteToTrainRepository routeToTrainRepository){
        this.routeToTrainRepository = routeToTrainRepository;
    }

    public void add(RouteToTrainTimeTable routeToTrainTimeTable){
        routeToTrainRepository.saveAndFlush(routeToTrainTimeTable);
    }

    public RouteToTrainTimeTable findById(Long id) throws Exception {
        return routeToTrainRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(Long id){
        routeToTrainRepository.deleteById(id);
    }

    public void setRouteToTrainTimeTableArriveTime(String id, String arriveTime){
        routeToTrainRepository.setRouteToTrainTimeTableArriveTime(Long.parseLong(id), Timestamp.valueOf(arriveTime));
    }
}
