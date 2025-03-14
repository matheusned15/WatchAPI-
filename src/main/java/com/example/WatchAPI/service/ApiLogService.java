package com.example.WatchAPI.service;

import com.example.WatchAPI.controller.ApiLog;
import com.example.WatchAPI.repositories.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiLogService {

    private final ApiLogRepository apiLogRepository;

    public List<ApiLog> getAllLogs() {
        return apiLogRepository.findAll();
    }

    public List<ApiLog> getLogsByEndpoint(String endpoint) {
        return apiLogRepository.findByEndpoint(endpoint);
    }
}
