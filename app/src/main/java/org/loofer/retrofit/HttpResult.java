package org.loofer.retrofit;


import android.content.Context;

import org.loofer.retrofit.config.ConfigLoader;


/**
 * BaseResponse Data T
 */
public class HttpResult<T> {
    //结果码
    private int code = 1;
    /*错误信息:msg, error, message*/
    private String msg, error, message;
    /*真实数据 data或者result*/
    private T data, result, newslist;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk(Context context) {
        return ConfigLoader.checkSucess(context, getCode());
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
