package com.example.WatchAPI.controller;

import com.example.WatchAPI.service.ApiLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogQueryController {

    private final ApiLogService apiLogService;

    @GetMapping
    public List<ApiLog> getAllLogs() {
        return apiLogService.getAllLogs();
    }

    @GetMapping("/{endpoint}")
    public List<ApiLog> getLogsByEndpoint(@PathVariable String endpoint) {
        return apiLogService.getLogsByEndpoint(endpoint);
    }
}
