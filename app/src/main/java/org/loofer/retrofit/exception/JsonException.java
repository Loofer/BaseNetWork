package org.loofer.retrofit.exception;

public class JsonException extends BaseException {
    public JsonException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
