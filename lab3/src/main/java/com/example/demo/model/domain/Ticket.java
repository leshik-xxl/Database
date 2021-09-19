package com.example.demo.model.domain;

import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.sevice.ClientService;
import com.example.demo.sevice.PlaceService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Ticket {

    public Ticket(String client, String place, String price, String buyDate, String privilege,
                  ClientRepository clientRepository, PlaceRepository placeRepository) throws Exception {
        final ClientService clientService = new ClientService(clientRepository);
        this.client = clientService.findById(Long.parseLong(client));
        final PlaceService placeService = new PlaceService(placeRepository);
        this.place = placeService.findById(Long.parseLong(place));
        this.price = BigDecimal.valueOf(new Double(price));
        this.buyDate = Timestamp.valueOf(buyDate);
        this.privilege = Boolean.valueOf(privilege);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "place_id", nullable = false, unique = true)
    private Place place;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp buyDate;

    @Column(nullable = false)
    private Boolean privilege;
}
