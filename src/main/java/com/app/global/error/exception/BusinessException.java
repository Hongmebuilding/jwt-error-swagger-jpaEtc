package com.app.global.error.exception;

import com.app.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;
}
