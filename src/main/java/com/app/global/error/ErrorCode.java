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
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "A-005", "해당 refresh token은 존재하지 않음"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-006", "해당 refresh token은 만료됐음"),
    NOT_ACCESS_TOKEN_TYPE(HttpStatus.UNAUTHORIZED, "A-007", "해당 token은 access token이 아인교"),
    FORBIDEN_ADMIN(HttpStatus.UNAUTHORIZED, "A-008", "관리자 Role이 아님"),

    //회원
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M-001", "잘못된 회원 타입"),
    ALREADY_REGISTERED_MEMBER(HttpStatus.BAD_REQUEST, "M-002", "이미 가입된 회원"),
    MEMBER_NOT_EXISTS(HttpStatus.BAD_REQUEST, "M-003", "해당 회원은 존재하지 않음");

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;
}
