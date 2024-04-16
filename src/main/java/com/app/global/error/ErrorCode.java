package com.app.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    TEST_(HttpStatus.INTERNAL_SERVER_ERROR, "001", "business"),

    //인증
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "expired token"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A-002", "invalid token"),
    NOT_EXISTS_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A-003", "Authorization Header 가 빈 값임"),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A-004", "인증타입이 bearer 타입이 아님"),

    //회원
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M-001", "잘못된 회원 타입");

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;
}
