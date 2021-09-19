package com.example.demo.repository;

import com.example.demo.model.domain.RouteToTrainTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface RouteToTrainRepository extends JpaRepository<RouteToTrainTimeTable, Long> {
    @Query("update RouteToTrainTimeTable r set r.arriveTime = :arriveTime where r.id = :routeToTrainTimeTableId")
    void setRouteToTrainTimeTableArriveTime(@Param("routeToTrainTimeTableId") Long id, @Param("arriveTime") Timestamp arriveTime);
}
