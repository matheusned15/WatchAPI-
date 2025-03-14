package com.example.WatchAPI.service;


import com.example.WatchAPI.controller.ApiLog;
import com.example.WatchAPI.entity.dto.ApiLogDTO;
import com.example.WatchAPI.repositories.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ApiLogRepository apiLogRepository;

    @KafkaListener(topics = "api_logs", groupId = "monitoring-group")
    public void consumeLog(ApiLogDTO log) {
        apiLogRepository.save(new ApiLog(null, log.getEndpoint(), log.getStatusCode(), log.getResponseTime(), log.getTimestamp()));
    }
}

