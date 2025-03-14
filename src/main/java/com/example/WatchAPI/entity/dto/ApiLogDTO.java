package com.example.WatchAPI.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiLogDTO {
    private String endpoint;
    private int statusCode;
    private long responseTime;
    private String timestamp;
}
