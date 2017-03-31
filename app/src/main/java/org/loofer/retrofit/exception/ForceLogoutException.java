package org.loofer.retrofit.exception;

/**
 * Created by Rockon on 12/27/16.
 * 强制退出的异常
 */

public class ForceLogoutException extends BaseException {
    public ForceLogoutException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
