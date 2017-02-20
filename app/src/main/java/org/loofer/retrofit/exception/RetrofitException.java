package org.loofer.retrofit.exception;

import android.net.ParseException;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.loofer.retrofit.Throwable;

import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * ============================================================
 * 版权： x x 版权所有（c）2017
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/20 15:41.
 * 描述：异常处理中心
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public class RetrofitException {

    private static final int UNAUTHORIZED = 401;           //连接失败
    private static final int FORBIDDEN = 403;              //禁止访问
    private static final int NOT_FOUND = 404;              //服务器地址未找到
    private static final int REQUEST_TIMEOUT = 408;        //请求超时
    private static final int INTERNAL_SERVER_ERROR = 500;  //服务器出错
    private static final int BAD_GATEWAY = 502;            //无效的请求
    private static final int SERVICE_UNAVAILABLE = 503;    //服务器不可用
    private static final int GATEWAY_TIMEOUT = 504;        //网关响应超时
    private static final int ACCESS_DENIED = 302;          //网络错误
    private static final int HANDEL_ERRROR = 417;          //接口处理失败

    public static Throwable handleException(java.lang.Throwable e) {

        Log.e("RetrofitException", e.getMessage());
        Throwable ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new Throwable(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    ex.setMessage("未授权的请求");
                case FORBIDDEN:
                    ex.setMessage("禁止访问");
                case NOT_FOUND:
                    ex.setMessage("服务器地址未找到");
                case REQUEST_TIMEOUT:
                    ex.setMessage("请求超时");
                case GATEWAY_TIMEOUT:
                    ex.setMessage("网关响应超时");
                case INTERNAL_SERVER_ERROR:
                    ex.setMessage("服务器出错");
                case BAD_GATEWAY:
                    ex.setMessage("无效的请求");
                case SERVICE_UNAVAILABLE:
                    ex.setMessage("服务器不可用");
                case ACCESS_DENIED:
                    ex.setMessage("网络错误");
                case HANDEL_ERRROR:
                    ex.setMessage("接口处理失败");
                default:
                    ex.setMessage(e.getMessage());
                    break;
            }
            ex.setCode(httpException.code());
            return ex;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new Throwable(resultException, resultException.code);
            ex.setMessage(resultException.getMessage());
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new Throwable(e, ERROR.PARSE_ERROR);
            ex.setMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new Throwable(e, ERROR.NETWORD_ERROR);
            ex.setMessage("连接失败");
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new Throwable(e, ERROR.SSL_ERROR);
            ex.setMessage("证书验证失败");
            return ex;
        } else if (e instanceof java.security.cert.CertPathValidatorException) {
            ex = new Throwable(e, ERROR.SSL_NOT_FOUND);
            ex.setMessage("证书路径没找到");
            return ex;
        }
        else if (e instanceof ConnectTimeoutException){
            ex = new Throwable(e, ERROR.TIMEOUT_ERROR);
            ex.setMessage("连接超时");
            return ex;
        } else if (e instanceof java.net.SocketTimeoutException) {
            ex = new Throwable(e, ERROR.TIMEOUT_ERROR);
            ex.setMessage("连接超时");
            return ex;
        } else if (e instanceof java.lang.ClassCastException) {
            ex = new Throwable(e, ERROR.FORMAT_ERROR);
            ex.setMessage("类型转换出错");
            return ex;
        } else if (e instanceof NullPointerException) {
            ex = new Throwable(e, ERROR.NULL);
            ex.setMessage("数据有空");
            return ex;
        } else if (e instanceof FormatException) {
            //服务端返回数据格式异常
            FormatException resultException = (FormatException) e;
            ex = new Throwable(resultException, resultException.code);
            ex.setMessage(resultException.message);
            return ex;
        } else {
            //其他未知异常
            ex = new Throwable(e, ERROR.UNKNOWN);
            ex.setMessage(e.getLocalizedMessage());
            return ex;
        }
    }


    /**
     * 和服务器约定的异常
     */
    public class ERROR {

        public static final int UNKNOWN = 1000;        //未知错误
        public static final int PARSE_ERROR = 1001;    //解析错误
        public static final int NETWORD_ERROR = 1002;  //网络错误
        public static final int HTTP_ERROR = 1003;     //协议出错
        public static final int SSL_ERROR = 1005;      //证书出错
        public static final int TIMEOUT_ERROR = 1006;  //连接超时
        public static final int SSL_NOT_FOUND = 1007;  //证书未找到
        public static final int NULL = -100;           //出现空值
        public static final int FORMAT_ERROR = 1008;   //格式错误
    }

}
