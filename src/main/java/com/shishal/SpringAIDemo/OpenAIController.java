package com.shishal.SpringAIDemo;

import com.shishal.SpringAIDemo.tool.DateTimeTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class OpenAIController {


    //@Qualifier("openai")
    private final ChatClient openApiChatClient;


    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        ChatResponse chatResponse = openApiChatClient
                .prompt(message)
                .tools(new DateTimeTool())
                .call()
                .chatResponse();

        log.info(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText();

        return ResponseEntity.ok(response);
    }

}
