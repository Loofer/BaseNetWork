package org.loofer.app;

import android.app.Application;
import android.content.Context;

import org.loofer.retrofit.Network;

import static okhttp3.internal.Internal.instance;

/**
 * ============================================================
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2017/2/26 15:48.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class App extends Application {

    public static App sAppContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        new Network.Builder()
//        .accept(Profile.API_ACCEPT)
                .baseUrl(Profile.API_ENDPOINT)
                .build();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    /**
     * @return application context
     */
    public static Context appContext() {
        return sAppContext;
    }


}
