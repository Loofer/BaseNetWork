package org.loofer.retrofit;


import android.util.Log;

import org.apache.http.conn.ConnectTimeoutException;
import org.loofer.retrofit.exception.ForceLogoutException;
import org.loofer.retrofit.exception.JsonException;
import org.loofer.retrofit.exception.NoDataException;
import org.loofer.retrofit.exception.OtherException;

import java.net.ConnectException;
import java.net.UnknownHostException;

import rx.Subscriber;

/**
 * ============================================================
 * 版权： x x 版权所有（c）2017
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/20 15:33.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private static final String TAG = "BaseSubscriber";

    @Override
    public void onError(java.lang.Throwable e) {
        if (e instanceof NoDataException) {
            // TODO: 2017/3/30 nodata
//            onFailure((NoDataException) e);
        } else if (e instanceof JsonException) {
            Log.e("BlueJsonException", e.getMessage());
        } else if (e instanceof ForceLogoutException) {
            // TODO: 2017/3/30  强制退出
        } else if (e instanceof ConnectException) {
            //getString("连接超时")
            onFailure("", "连接失败");
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            //getString("证书验证失败")
            onFailure("", "证书验证失败");
        } else if (e instanceof java.security.cert.CertPathValidatorException) {
            //getString("证书路径没找到")
            onFailure("", "证书路径没找到");
        } else if (e instanceof ConnectTimeoutException) {
            //getString("连接超时")
            onFailure("", "连接超时");
        } else if (e instanceof java.net.SocketTimeoutException) {
            //getString("连接超时")
            onFailure("", "连接超时");
        } else if (e instanceof java.lang.ClassCastException) {
            //getString("连接超时")
            onFailure("", "连接超时");
        } else if (e instanceof UnknownHostException) {
            //getString("请求地址有问题")
            onFailure("", "请求地址有问题");
        } else if (e instanceof NullPointerException) {
            //getString("数据有空")
            onFailure("", "数据有空");
        } else if (e instanceof OtherException) {
            // 其他错误
            onFailure(((OtherException) e).getErrorCode(), ((OtherException) e).getErrorMessage());
        } else {
            //其他未知异常
            onFailure("", "未知错误");
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "-->http is start");
        // todo some common as show loadding  and check netWork is NetworkAvailable
        // if  NetworkAvailable no !   must to call onCompleted
    }

    @Override
    public void onCompleted() {
        Log.v(TAG, "-->http is Complete");
        // todo some common as  dismiss loadding
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onFailure(String errorCode, String errorMsg);

    protected abstract void onSuccess(T data);

}
