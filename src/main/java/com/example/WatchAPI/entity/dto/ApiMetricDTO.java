package com.example.WatchAPI.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiMetricDTO {

    private String apiName;
    private String endpoint;
    private int responseTimeMs;
    private int statusCode;
    private LocalDateTime timestamp;
}
