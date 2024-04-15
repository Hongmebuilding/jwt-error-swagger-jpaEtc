package com.app.jwtpractice.global.error.exception;


import com.app.jwtpractice.global.error.ErrorCode;

public class AuthenticationException extends BusinessException {

    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }

}
