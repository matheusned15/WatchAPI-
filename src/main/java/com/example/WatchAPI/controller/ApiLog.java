package com.example.WatchAPI.controller;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "api_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpoint;
    private int statusCode;
    private long responseTime;
    private String timestamp;
}
