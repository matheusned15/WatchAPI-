package com.example.WatchAPI.service;

import com.example.WatchAPI.entity.dto.ApiMetricDTO;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    private final KafkaProducerService kafkaProducerService;

    public MonitoringService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    public void processMetric(ApiMetricDTO metric) {
        // Possíveis validações e transformações antes do envio ao Kafka
        kafkaProducerService.sendMetric(metric);
    }
}
