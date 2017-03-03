package org.loofer.retrofit.transformer;

import org.loofer.retrofit.exception.ApiException;

import rx.Observable;
import rx.functions.Func1;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 10:57.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {

    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ApiException.handleException(throwable));
    }
}
