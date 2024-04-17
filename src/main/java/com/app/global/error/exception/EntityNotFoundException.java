package com.app.global.error.exception;

import com.app.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode); // 부모 생성자 호출하면서 에러 코드 넘겨줌
    }
}
