package org.loofer.retrofit.interceptor;


import org.loofer.retrofit.account.AccountManager;
import org.loofer.retrofit.utils.Strings;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 11:30.
 * 描述：请求头拦截器
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class DefaultHeaderInterceptor implements Interceptor {

    private Headers.Builder builder;
    public DefaultHeaderInterceptor(Headers.Builder builder) {
        this.builder = builder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (builder == null) {
            builder = new Headers.Builder();
        }

        final String token = AccountManager.INSTANCE.token();
        if (!Strings.isBlank(token)) {
            builder.set("Authorization", "Bearer " + token);
        }

        Request compressedRequest = originalRequest
                .newBuilder()
                .headers(builder.build())
                .build();

        return chain.proceed(compressedRequest);
    }
}
