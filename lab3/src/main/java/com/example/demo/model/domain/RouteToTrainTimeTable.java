package com.example.demo.model.domain;

import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.sevice.RouteService;
import com.example.demo.sevice.TrainService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"route_id", "train_id"})})
public class RouteToTrainTimeTable {

    public RouteToTrainTimeTable(String route, String train, String arriveTime, String departTime,
                                 RouteRepository routeRepository, TrainRepository trainRepository) throws Exception {
        final RouteService routeService = new RouteService(routeRepository);
        this.route = routeService.findById(Long.parseLong(route));
        final TrainService trainService = new TrainService(trainRepository);
        this.train = trainService.findById(train);
        this.arriveTime = Timestamp.valueOf(arriveTime);
        this.departTime = Timestamp.valueOf(departTime);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(nullable = false)
    private Timestamp arriveTime;

    @Column(nullable = false)
    private Timestamp departTime;
}
