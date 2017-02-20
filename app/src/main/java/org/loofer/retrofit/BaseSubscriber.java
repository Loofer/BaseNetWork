package org.loofer.retrofit;


import android.util.Log;

import org.loofer.retrofit.exception.RetrofitException;

import rx.Subscriber;

/**
 * ============================================================
 * 版权： x x 版权所有（c）2016
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
        Log.v(TAG, e.getMessage());
        if (e instanceof Throwable) {
            Log.e(TAG, "--> e instanceof Throwable");
            onError((Throwable) e);
        } else {
            Log.e(TAG, "e !instanceof Throwable");
            onError(new Throwable(e, RetrofitException.ERROR.UNKNOWN));
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

    public abstract void onError(Throwable e);

}
