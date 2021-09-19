package com.example.demo.repository;

import com.example.demo.model.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("update Ticket t set t.price = :price where t.id = :ticketId")
    void setTicketPrice(@Param("ticketId") Long id, @Param("price") BigDecimal price);
}
