package com.example.demo.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Route {

    public Route(String placeOfDeparture, String placeOfArrival){
        this.placeOfArrival = placeOfArrival;
        this.placeOfDeparture = placeOfDeparture;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placeOfDeparture;

    @Column(nullable = false)
    private String placeOfArrival;
}
