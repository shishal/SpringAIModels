package com.shishal.SpringAIDemo;

import com.shishal.SpringAIDemo.tool.DateTimeTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
@Slf4j
@RequiredArgsConstructor
public class OllamaController {

    private final ChatClient ollamaChatClient;

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

        ChatResponse chatResponse = ollamaChatClient
                .prompt(message)
                .tools(new DateTimeTool())
                .call()
                .chatResponse();

        log.info(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText();

        return ResponseEntity.ok(response);
    }

}
