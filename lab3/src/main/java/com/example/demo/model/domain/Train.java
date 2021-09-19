package com.example.demo.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Train {

    public Train(String idTrain, String maxCarriage){
        this.idTrain = idTrain;
        this.maxCarriage = Integer.parseInt(maxCarriage);
    }

    @Id
    private String idTrain;

    @Column(nullable = false)
    private Integer maxCarriage;
}
