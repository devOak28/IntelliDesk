package com.intellidesk.tools;

import com.intellidesk.entity.Priority;
import com.intellidesk.entity.Status;
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

    @Tool(description = "Create a new ticket in the database" +
            "IMPORTANT:\n" +
            "Only call this tool after the user has explicitly confirmed\n" +
            "that they want to create a ticket.\n" +
            "\n" +
            "Never call this tool merely because the user reported an issue.\n" +
            "\n" +
            "Never invent priority. Status will always be OPEN\n" +
            "\n" +
            "The user must explicitly provide the required ticket information.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details") Ticket ticket) {
        System.out.println("Creating ticket: " + ticket);
        return ticketService.createTicket(ticket);
    }

    @Tool(description = "Get a ticket by username")
    public Ticket getTicketByUsernameTool(@ToolParam(description = "Username of the ticket owner") String username) {
        System.out.println("Fetching ticket for username: " + username);
        return ticketService.getTicketByUsername(username);
    }

    @Tool(description = "Update an existing ticket. Only the fields that need to be changed should be provided.")
    public String updateTicketTool(
            @ToolParam(description = "ID of the existing ticket") Long id,

            @ToolParam(description = "New summary. Pass null if summary should not be changed.")
            String summary,

            @ToolParam(description = "New priority: LOW, MEDIUM, or HIGH. Pass null if priority should not be changed.")
            Priority priority,

            @ToolParam(description = "New status: OPEN, IN_PROGRESS, or CLOSED. Pass null if status should not be changed.")
            Status status) {

        System.out.println(
                "Updating ticket id=" + id +
                        ", summary=" + summary +
                        ", priority=" + priority +
                        ", status=" + status
        );

        return ticketService.updateTicket(id, summary, priority, status);
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

    // ***************************** LEVEL 1 ***************************************
    // TASK 1
    @Tool(description = "Get the count of tickets by status")
    public int getTicketCountByStatus(@ToolParam(description = "The status to filter tickets by") Status status){
        return ticketService.getTicketCountByStatus(status);
    }

    // TASK 2
    @Tool(description = "Get a ticket by username")
    public Ticket getTicketByUserName(@ToolParam(description = "Username of the ticket owner") String username){
        String userNameCaseSensetive = username.toLowerCase();
        return ticketService.getTicketByUsername(userNameCaseSensetive);
    }
    //TASK 3
    @Tool(description = "Close a ticket")
    public String closeTicket(@ToolParam(description = "ID of the ticket to be closed") Long id){
        return ticketService.updateTicket(id, "", null, Status.CLOSED);
    }

    //Task 4 — Partial Ticket Update
    @Tool(description = "Update an existing ticket. Only the fields that need to be changed should be provided.")
    public String updateTicket(@ToolParam(description = "ID of the existing ticket") Long id,
                               @ToolParam(description = "New summary. Pass null if summary should not be changed.") String summary,
                               @ToolParam(description = "New priority: LOW, MEDIUM, or HIGH. Pass null if priority should not be changed.") Priority priority,
                               @ToolParam(description = "New status: OPEN, IN_PROGRESS, or CLOSED. Pass null if status should not be changed.") Status status) {
        return ticketService.updateTicket(id, summary, priority, status);
    }

    // NEW CHALLENGE LEVEL 1 — Make IntelliDesk Understand Context
    // Challenge 1: Query Rewriting with an Advisor
}
