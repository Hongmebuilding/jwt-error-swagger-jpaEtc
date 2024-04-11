package com.app.jwtpractice.api.exceptionTest.controller;

import com.app.jwtpractice.api.exceptionTest.dto.BindExceptionTestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exception")
public class ExceptionTestController {
    @GetMapping("/bind-exception-test")
    public String bindExceptionTest(@Valid BindExceptionTestDto bindExceptionTestDto) {
        return "ok";
    }
}
