package org.loofer.retrofit.exception;


public class BusinessException extends BaseException {
    public BusinessException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
