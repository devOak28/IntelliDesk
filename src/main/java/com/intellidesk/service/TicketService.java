package com.intellidesk.service;

import com.intellidesk.entity.Priority;
import com.intellidesk.entity.Status;
import com.intellidesk.entity.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    Ticket getTicketByUsername(String username);

    String updateTicket(Long id, String summary, Priority priority, Status status);

    int getTicketCountByStatus(Status status);
}
