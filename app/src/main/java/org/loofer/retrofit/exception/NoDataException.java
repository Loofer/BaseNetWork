package org.loofer.retrofit.exception;

/**
 *
 * Created by Jaron.Wu on 16-11-11.
 */
public class NoDataException extends BaseException {
    public NoDataException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
