package com.intellidesk.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You're a helpful assistant that helps users with their queries. You should provide clear and concise answers to their questions within 400 words. If you don't know the answer, you should say 'I don't know' and not make up an answer.")
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
