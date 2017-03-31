package org.loofer.retrofit.exception;

public class NoNetException extends BaseException {
    public NoNetException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
