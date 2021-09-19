package com.example.demo.repository;

import com.example.demo.model.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Query("update Place p set p.number = :number where p.id = :placeId")
    void setPlaceNumber(@Param("placeId") Long id, @Param("number") Integer number);
}
