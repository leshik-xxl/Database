package com.example.demo;

import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final TicketRepository ticketRepository;
    private final PlaceRepository placeRepository;
    private final CarriageRepository carriageRepository;
    private final TrainRepository trainRepository;
    private final RouteRepository routeRepository;
    private final RouteToTrainRepository routeToTrainRepository;


    public DemoApplication(ClientRepository clientRepository, TicketRepository ticketRepository,
                           PlaceRepository placeRepository, CarriageRepository carriageRepository,
                           TrainRepository trainRepository, RouteRepository routeRepository,
                           RouteToTrainRepository routeToTrainRepository) {
        this.clientRepository = clientRepository;
        this.ticketRepository = ticketRepository;
        this.placeRepository = placeRepository;
        this.carriageRepository = carriageRepository;
        this.trainRepository = trainRepository;
        this.routeRepository = routeRepository;
        this.routeToTrainRepository = routeToTrainRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
