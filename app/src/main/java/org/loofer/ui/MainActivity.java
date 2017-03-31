package org.loofer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.loofer.bean.News;
import org.loofer.retrofit.BaseSubscriber;
import org.loofer.retrofit.HttpResult;
import org.loofer.retrofit.Network;
import org.loofer.retrofit.R;
import org.loofer.retrofit.transformer.SchedulerTransformer;
import org.loofer.service.DoubanService;

import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = Network.get().retrofit();
        DoubanService doubanService = retrofit.create(DoubanService.class);
        doubanService.getNews("8875df228f1fda798d597ae4a084b4d0", 1, 10)
                .compose(new SchedulerTransformer<HttpResult<List<News>>>())
                .subscribe(new BaseSubscriber<HttpResult<List<News>>>() {
                    @Override
                    protected void onFailure(String errorCode, String errorMsg) {
                        Log.e("===", "请求失败" + ":" + errorMsg);
                    }

                    @Override
                    protected void onSuccess(HttpResult<List<News>> data) {

                        Log.e("===", "请求成功");
                    }
                });


//        Observable<HttpResult<String>> observable = (Observable<HttpResult<String>>) doubanService.executePostBody("http:123456");
//
//        observable.compose(new ErrHandleTransformer<String>())
//                .compose(new SchedulerTransformer<String>())
//                .subscribe(new BaseSubscriber<String>() {
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                });

    }

}
