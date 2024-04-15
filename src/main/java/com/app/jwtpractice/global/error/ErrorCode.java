package com.app.jwtpractice.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    TEST_(HttpStatus.INTERNAL_SERVER_ERROR, "001", "business"),

    //인증
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "expired token"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A-002", "invalid token")
    ;

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;
}
