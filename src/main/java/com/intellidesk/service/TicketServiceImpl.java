package com.intellidesk.service;

import com.intellidesk.entity.Priority;
import com.intellidesk.entity.Status;
import com.intellidesk.entity.Ticket;
import com.intellidesk.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public Ticket createTicket(Ticket ticket) {
        System.out.println("Creating ticket: " + ticket);
        var newTicket = ticketRepository.save(ticket);
        System.out.println("Ticket created: " + newTicket);
        return newTicket;
    }

    @Override
    public Ticket getTicketById(Long id) {
        System.out.println("Fetching ticket for ID: " + id);
        var ticket = ticketRepository.findById(id).orElse(null);
        System.out.println("Found ticket: " + ticket);
        return ticket;
    }

    @Override
    public Ticket getTicketByUsername(String username) {
        System.out.println("Fetching ticket for username: " + username);
        var result = ticketRepository.findByUsername(username).orElse(null);
        System.out.println("Found ticket: " + result);
        return result;
    }

    @Override
    public String updateTicket(Long id, String summary, Priority priority, Status status) {
        var updatedTicket = ticketRepository.updateTicket(id, summary, priority.name(), status.name());
        System.out.println("Ticket updated: " + updatedTicket);
        return "Ticket updated successfully";
    }

}
