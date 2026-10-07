package com.intellidesk.service;

import com.intellidesk.tools.TicketDBTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private  ChatClient chatClient;

    @Autowired
    private TicketDBTools ticketDBTools;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;

    public String getResponseFromAssistant(String query,String userName){
        return chatClient.prompt()
                .tools(ticketDBTools)
                .user("""
        username: %s

        User query:
        %s
                         IMPORTANT:
                                The username above is the actual username of the current user.
                                Do not replace it with a username mentioned inside the query message.
        """.formatted(userName, query))
                .system(systemPromptResource)
                .advisors(a-> a.param(ChatMemory.CONVERSATION_ID,userName))
                .call()
                .content();
    }
}
