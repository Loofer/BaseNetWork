package org.loofer.retrofit.transformer;

import org.loofer.retrofit.HttpResult;

import rx.Observable;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 10:55.
 * 描述：<HttpResult<T>, T>这里有问题需要后期修改
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
// TODO: 2017/2/26 <HttpResult<T>, T>这里有问题需要后期修改
public class ErrHandleTransformer<T> implements Observable.Transformer<HttpResult<T>, T> {
    @Override
    public Observable<T> call(Observable<HttpResult<T>> observable) {
        return ((Observable) observable)
                //.map(new HandleFuc<T>())
                .onErrorResumeNext(new HttpResponseFunc<T>());
    }
}
