package com.example.WatchAPI.service;


import com.example.WatchAPI.entity.dto.ApiMetricDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "api-metrics";

    private final KafkaTemplate<String, ApiMetricDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, ApiMetricDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMetric(ApiMetricDTO metric) {
        logger.info("Enviando métrica ao Kafka: {}", metric);
        kafkaTemplate.send(TOPIC, metric);
    }
}
