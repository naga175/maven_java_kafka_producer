package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaProducerService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaProducerService producerService;

    @Autowired
    public MessageController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka: " + message;
    }
}
