package com.proyecto.ieti.pemc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.ieti.pemc.service.ChatGPTService;

@RestController
@RequestMapping("/api/chat")
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping
    public String chatWithAI(@RequestBody String message) {
        return chatGPTService.getAIResponse(message);
    }
}
