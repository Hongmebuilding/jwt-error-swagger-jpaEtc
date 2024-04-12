package com.app.jwtpractice.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    TEST_(HttpStatus.INTERNAL_SERVER_ERROR, "001", "business");

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;
}
