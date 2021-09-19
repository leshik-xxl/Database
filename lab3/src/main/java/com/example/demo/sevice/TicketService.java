package com.example.demo.sevice;

import com.example.demo.model.domain.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void add(Ticket ticket){
        ticketRepository.saveAndFlush(ticket);
    }

    public Ticket findById(Long id) throws Exception {
        return ticketRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }

    public void setTicketPrice(String id, String price){
        ticketRepository.setTicketPrice(Long.parseLong(id), BigDecimal.valueOf(new Double(price)));
    }
}
