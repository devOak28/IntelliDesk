package com.intellidesk.service;

import com.intellidesk.entity.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    Ticket getTicketByUsername(String username);
    Ticket updateTicket(Ticket ticket);
}
