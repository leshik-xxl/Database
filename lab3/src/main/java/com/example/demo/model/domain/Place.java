package com.example.demo.model.domain;

import com.example.demo.repository.CarriageRepository;
import com.example.demo.sevice.CarriageService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "carriage_fk"})})
public class Place {

    public Place(String number, String carriageRepositoryId, CarriageRepository carriageRepository) throws Exception {
        this.number = Integer.parseInt(number);
        final CarriageService carriageService = new CarriageService(carriageRepository);
        this.carriage = carriageService.findById(carriageRepositoryId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "carriage_fk", nullable = false)
    private Carriage carriage;
}
