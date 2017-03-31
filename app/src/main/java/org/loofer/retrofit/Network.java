package org.loofer.retrofit;

import android.util.Log;

import org.loofer.retrofit.interceptor.ExceptionInterceptor;
import org.loofer.retrofit.utils.Preconditions;
import org.loofer.retrofit.utils.Strings;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2017
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/25 15:54.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class Network {

    private String baseUrl;
    private Retrofit mRetrofit;
    private OkHttpClient client;

    // Make this class a thread safe singleton
    private static class SingletonHolder {
        private static final Network INSTANCE = new Network();
    }

    public static synchronized Network get() {
        return SingletonHolder.INSTANCE;
    }

    private Network() {
    }


    public Retrofit retrofit() {
        Preconditions.checkNotNull(baseUrl, "Base URL required.");
        if (mRetrofit == null) {
            mRetrofit = newRetrofitBuilder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    protected Retrofit.Builder newRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    public static final class Builder {

        private static final String TAG = "NetWork";
        private String baseUrl;
        private String accept;
        private Headers.Builder headerBuilder;
        private OkHttpClient mClient;
        private boolean isLog;

        public Network build() {
            Preconditions.checkNotNull(baseUrl, "Base URL required.");
            ensureSaneDefaults();

            Network network = get();
            network.baseUrl = baseUrl;
            network.client = mClient;

            return network;
        }

        private void ensureSaneDefaults() {
            if (mClient == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                if (isLog) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.d(TAG, message);
                        }
                    });
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.addNetworkInterceptor(loggingInterceptor);
                }

                if (headerBuilder == null) {
                    headerBuilder = defaultHeader();
                }
                if (!Strings.isBlank(accept)) {
                    headerBuilder.add("Accept", accept);
                }

//                DefaultHeaderInterceptor headerInterceptor = new DefaultHeaderInterceptor(headerBuilder);
//                builder.addInterceptor(headerInterceptor);

                ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor();
                builder.addInterceptor(exceptionInterceptor);

                mClient = builder.build();
            }
        }

        public Builder client(OkHttpClient client) {
            mClient = client;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            Preconditions.checkNotNull(baseUrl, "baseUrl == null");
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder networkDebug(boolean networkDebug) {
            this.isLog = networkDebug;
            return this;
        }

        public Builder accept(String accept) {
            Preconditions.checkNotNull(accept, "accept == null");
            this.accept = accept;
            return this;
        }

        public Builder addHeader(String name, String value) {
            if (headerBuilder == null) {
                headerBuilder = defaultHeader();
            }
            headerBuilder.set(name, value);
            return this;
        }

        private Headers.Builder defaultHeader() {
//            final AppInfo appInfo = SupportApp.appInfo();
            Headers.Builder builder = new Headers.Builder();
            builder.add("Content-Encoding", "gzip");
//                    .add("X-Client-Build", String.valueOf(appInfo.versionCode))
//                    .add("X-Client-Version", appInfo.version)
//                    .add("X-Client", appInfo.deviceId)
//                    .add("X-Language-Code", appInfo.languageCode)

//                    .add("X-Client-Build", String.valueOf("14254"))
//                    .add("X-Client-Version", "454564")
//                    .add("X-Client", "454")
//                    .add("X-Language-Code", "45645")
//                    .add("X-Client-Type", "android");

//            final String channel = appInfo.channel;
//            final String channel = "sjdkflj";
//            if (!TextUtils.isEmpty(channel)) {
//                builder.add("X-Client-Channel", channel);
//            }
            return builder;
        }
    }

}
