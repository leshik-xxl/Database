package com.example.demo.model.domain;

import com.example.demo.repository.RouteToTrainRepository;
import com.example.demo.sevice.RouteToTrainService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "id"})})
public class Carriage {

    public Carriage(String id, String type, String number, String routeToTrainTimeTable,
                    RouteToTrainRepository routeToTrainRepository) throws Exception {
        this.id = id;
        this.type = type;
        this.number = Integer.parseInt(number);
        final RouteToTrainService routeToTrainService = new RouteToTrainService(routeToTrainRepository);
        this.routeToTrainTimeTable = routeToTrainService.findById(Long.parseLong(routeToTrainTimeTable));
    }

    @Id
    private String id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne

    @JoinColumn(name = "route_to_train_time_table", nullable = false)
    private RouteToTrainTimeTable routeToTrainTimeTable;
}
