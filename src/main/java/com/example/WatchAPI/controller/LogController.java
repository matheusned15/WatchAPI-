package com.example.WatchAPI.controller;

import com.example.WatchAPI.entity.dto.ApiLogDTO;
import com.example.WatchAPI.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final KafkaProducerService kafkaProducer;

    @PostMapping
    public String sendLog(@RequestBody ApiLogDTO log) {
        log.setTimestamp(Instant.now().toString());
        kafkaProducer.sendLog(log);
        return "Log enviado para o Kafka!";
    }
}
