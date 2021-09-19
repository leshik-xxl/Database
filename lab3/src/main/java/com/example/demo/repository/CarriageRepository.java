package com.example.demo.repository;

import com.example.demo.model.domain.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageRepository extends JpaRepository<Carriage, String> {

    @Query("update Carriage c set c.type = :type where c.id = :carriageId")
    void setCarriageType(@Param("carriageId") String id, @Param("type") String type);
}

