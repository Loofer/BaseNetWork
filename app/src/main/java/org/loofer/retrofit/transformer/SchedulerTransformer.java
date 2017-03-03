package org.loofer.retrofit.transformer;

import org.loofer.retrofit.R;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2017
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 10:49.
 * 描述：网络请求回调的转换类
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class SchedulerTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> observable) {
        return (Observable<T>) observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}
