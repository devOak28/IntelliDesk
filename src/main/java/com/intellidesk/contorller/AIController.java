package com.intellidesk.contorller;

import com.intellidesk.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    @GetMapping
    public ResponseEntity<String> getResponseFromAssistant(String query) {
        return ResponseEntity.ok(aiService.getResponseFromAssistant(query));
    }
}
