package com.example.WatchAPI.controller;

import com.example.WatchAPI.entity.dto.ApiMetricDTO;
import com.example.WatchAPI.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitoringController {

    private final MonitoringService monitoringService;

    @PostMapping("/metrics")
    public ResponseEntity<String> receiveMetric(@RequestBody ApiMetricDTO metric) {
        monitoringService.processMetric(metric);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Métrica recebida com sucesso.");
    }
}

