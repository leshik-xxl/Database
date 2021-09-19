package com.example.demo.repository;

import com.example.demo.model.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, String> {
    @Query("update Train t set t.maxCarriage = :maxCarriage where t.idTrain = :trainId")
    void setTrainMaxCarriage(@Param("trainId") String id, @Param("maxCarriage") Integer maxCarriage);
}
