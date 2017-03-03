package org.loofer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.loofer.retrofit.BaseSubscriber;
import org.loofer.retrofit.HttpResult;
import org.loofer.retrofit.Network;
import org.loofer.retrofit.R;
import org.loofer.retrofit.Throwable;
import org.loofer.retrofit.transformer.ErrHandleTransformer;
import org.loofer.retrofit.transformer.SchedulerTransformer;
import org.loofer.service.DoubanService;

import retrofit2.Retrofit;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    private Observable.Transformer exceptTransformer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = Network.get().retrofit();
        DoubanService doubanService = retrofit.create(DoubanService.class);
        Observable<HttpResult<String>> observable = (Observable<HttpResult<String>>) doubanService.executePostBody("http:123456");

        observable.compose(new ErrHandleTransformer<String>())
                .compose(new SchedulerTransformer<String>())
                .subscribe(new BaseSubscriber<String>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });

    }

}
