package com.example.WatchAPI.service;


import com.example.WatchAPI.entity.dto.ApiLogDTO;
import com.example.WatchAPI.entity.dto.ApiMetricDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private static final String METRICS_TOPIC = "api-metrics";
    private static final String LOGS_TOPIC = "api-logs";

    private final KafkaTemplate<String, ApiMetricDTO> metricKafkaTemplate;
    private final KafkaTemplate<String, ApiLogDTO> logKafkaTemplate;

    public KafkaProducerService(
            KafkaTemplate<String, ApiMetricDTO> metricKafkaTemplate,
            KafkaTemplate<String, ApiLogDTO> logKafkaTemplate) {
        this.metricKafkaTemplate = metricKafkaTemplate;
        this.logKafkaTemplate = logKafkaTemplate;
    }

    public void sendMetric(ApiMetricDTO metric) {
        logger.info("Enviando métrica ao Kafka: {}", metric);
        metricKafkaTemplate.send(METRICS_TOPIC, metric);
    }

    public void sendLog(ApiLogDTO log) {
        logger.info("Enviando log ao Kafka: {}", log);
        logKafkaTemplate.send(LOGS_TOPIC, log);
    }
}
