package com.app.jwtpractice.global.error.exception;

import com.app.jwtpractice.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;
}
