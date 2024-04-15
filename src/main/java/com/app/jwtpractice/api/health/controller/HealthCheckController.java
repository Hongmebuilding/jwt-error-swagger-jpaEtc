package com.app.jwtpractice.api.health.controller;

import com.app.jwtpractice.api.health.dto.HealthCheckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // 생성자 주입
public class HealthCheckController {
    //개발환경인지 운영환경인지
    private final Environment environment;

    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponseDto> healthCheck() {
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        HealthCheckResponseDto healthCheckResponseDto = HealthCheckResponseDto.builder()
                .health("ok")
                .activeProfiles(Arrays.asList(environment.getActiveProfiles()))
                .build();

        return ResponseEntity.ok(healthCheckResponseDto);
    }

}
