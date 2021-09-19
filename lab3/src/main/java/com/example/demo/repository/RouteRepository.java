package com.example.demo.repository;

import com.example.demo.model.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("update Route r set r.placeOfArrival = :placeOfArrival where r.id = :routeId")
    void setRoutePlaceOfArrival(@Param("routeId") Long id, @Param("placeOfArrival") String placeOfArrival);
}
