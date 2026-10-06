package com.intellidesk.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private  ChatClient chatClient;

    public String getResponseFromAssistant(String query){
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }
}
