package com.intellidesk.tools;

import com.intellidesk.entity.Ticket;
import com.intellidesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class TicketDBTools {
    @Autowired
    private TicketService ticketService;

    @Tool(description = "Create a new ticket in the database")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details") Ticket ticket) {
        System.out.println("Creating ticket: " + ticket);
        return ticketService.createTicket(ticket);
    }

    @Tool(description = "Get a ticket by username")
    public Ticket getTicketByUsernameTool(@ToolParam(description = "Username of the ticket owner") String username) {
        System.out.println("Fetching ticket for username: " + username);
        return ticketService.getTicketByUsername(username);
    }

    @Tool(description = "Update a ticket in the database")
    public Ticket updateTicketTool(@ToolParam(description = "Ticket details which needs to be updated") Ticket ticket) {
        System.out.println("Updating ticket: " + ticket);
        return ticketService.updateTicket(ticket);
    }

    @Tool(description = "Get the current time in milliseconds")
    public LocalDateTime getCurrentTime(){
        System.out.println("Fetching current time in milliseconds");
        return LocalDateTime.now();
    }

    @Tool(description = "Get the current date and time in the format dd-MMMM-yyyy hh:mm a. use it only showing date and time to the user in response. Do not use it for storing in database or for any other purpose.")
    public String getCurrentDateAndTime(){
        System.out.println("Fetching current date and time");
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm a");
        return LocalDateTime.now().format(formatter);
    }
}
