package com.shishal.SpringAIDemo.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public ChatClient ollamaChatClient(OllamaChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder(MessageWindowChatMemory
                                .builder()
                                .maxMessages(100)
                                .build())
                        .build())
                .build();
    }
    @Bean
    public ChatClient openApiChatClient(OpenAiChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder(MessageWindowChatMemory
                                .builder()
                                .maxMessages(100)
                                .build())
                        .build())
                .build();
    }
}
