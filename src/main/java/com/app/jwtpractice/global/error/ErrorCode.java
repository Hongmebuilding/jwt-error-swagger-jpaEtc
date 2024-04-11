package com.app.jwtpractice.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
}
