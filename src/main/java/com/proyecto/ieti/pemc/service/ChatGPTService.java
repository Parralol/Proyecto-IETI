package com.proyecto.ieti.pemc.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ChatGPTService {

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String apiKey;


      public String getAIResponse(String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);

            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(new RequestPayload("gpt-3.5-turbo", message));

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    public class RequestPayload {
        private final String model;
        private final Message[] messages;
    
        public RequestPayload(String model, String content) {
            this.model = model;
            this.messages = new Message[]{new Message("user", content)};
        }
    
        public String getModel() {
            return model;
        }
    
        public Message[] getMessages() {
            return messages;
        }
    
        public static class Message {
            private final String role;
            private final String content;
    
            public Message(String role, String content) {
                this.role = role;
                this.content = content;
            }
    
            public String getRole() {
                return role;
            }
    
            public String getContent() {
                return content;
            }
        }
    }
}
