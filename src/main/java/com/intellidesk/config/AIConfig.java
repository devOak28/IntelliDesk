package com.intellidesk.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    private Logger logger = LoggerFactory.getLogger(AIConfig.class);
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        logger.info("Configuring ChatClient with default system prompt and advisors.");
        logger.info("chatMemory bean created: " + chatMemory.getClass().getName());
        return builder
                .defaultSystem(
                        "You are a Help Desk Assistant.\n" +
                                "\n" +
                                "When the user asks about their ticket, you must use the\n" +
                                "getTicketByUsernameTool.\n" +
                                "\n" +
                                "Never use placeholder values such as:\n" +
                                "\"your_username\",\n" +
                                "\"username\",\n" +
                                "\"user\",\n" +
                                "\"example\",\n" +
                                "\"test\".\n" +
                                "\n" +
                                "Always extract the actual username provided by the user.\n" +
                                "\n" +
                                "If the user has not provided a username, ask:\n" +
                                "\"Please provide your username so I can check your ticket.\"\n" +
                                "\n" +
                                "Never guess the username.")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }
}
