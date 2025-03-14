package com.example.WatchAPI.repositories;

import com.example.WatchAPI.controller.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
    List<ApiLog> findByEndpoint(String endpoint);
}
