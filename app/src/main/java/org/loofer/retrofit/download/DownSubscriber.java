package org.loofer.retrofit.download;

import android.content.Context;
import android.util.Log;

import org.loofer.retrofit.BaseSubscriber;
import org.loofer.retrofit.Throwable;

/**
 * ============================================================
 * 版权： x x 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/20 18:20.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public class DownSubscriber<ResponseBody extends okhttp3.ResponseBody> extends BaseSubscriber<ResponseBody> {

    private DownLoadCallBack callBack;
    private Context context;
    private String path;
    private String name;
    private String key;

    public DownSubscriber(String key, String path, String name, DownLoadCallBack callBack, Context context) {
        this.key = key;
        this.path = path;
        this.name = name;
        this.callBack = callBack;
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (callBack != null) {
           /* if (TextUtils.isEmpty(key)) {
                key = FileUtil.generateFileKey(path, name);
            }*/
            callBack.onStart(key);
        }
    }

    @Override
    public void onCompleted() {
        if (callBack != null) {
            callBack.onCompleted();
        }
    }


    @Override
    public void onError(final Throwable e) {
        Log.e(DownLoadManager.TAG, "DownSubscriber:>>>> onError:" + e.getMessage());
        callBack.onError(e);
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        Log.d(DownLoadManager.TAG, "DownSubscriber:>>>> onNext");
        new DownLoadManager(callBack).writeResponseBodyToDisk(key, path, name, context, responseBody);

    }

}
