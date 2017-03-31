package org.loofer.retrofit.exception;

/**
 * ============================================================
 * 版权：  xx 版权所有（c）2017
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/20 15:46.
 * 描述：自定义异常处理
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public class BaseException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public BaseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
