package com.example.administrator.thefirstnavigation.modle;

import android.util.Log;

import com.example.administrator.thefirstnavigation.MvpInterface.UploadHeadImageMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdateInfoBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/1/18.
 */

public class UploadHeadModleIml  implements UploadHeadImageMvp.UploadHeadModle {
    @Override
    public void getUploadHead(File file, final UploadHeadImageMvp.UploadHeadCallBack uploadHeadCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        uploadHeadCallBack.setShowProgressbar();
        retorfitUnits.getUploadHeadImage(file).compose(RxUtils.<MainBean<UploadHeadImageBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UploadHeadImageBean>handleResult())
                .subscribe(new BaseObserver<UploadHeadImageBean>(uploadHeadCallBack) {
                    @Override
                    public void onNext(UploadHeadImageBean value) {
                        uploadHeadCallBack.setUploadHead(value);
                    }
                });

    }

    @Override
    public void getUpdateInfo(String json, final UploadHeadImageMvp.UploadHeadCallBack updateInfoCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        updateInfoCallBack.setShowProgressbar();
        Log.d("lol", "getUpdateInfo: "+json);
        retorfitUnits.getUpdateInfo(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
                .flatMap(new Function<MainBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final MainBean mainBean) throws Exception {
                        if(mainBean.getCode()!=0){
                            return  Observable.error(new SeveryEcception(mainBean.getCode(),mainBean.getMessage()));
                        }else{
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    }catch (Exception e1){
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(updateInfoCallBack) {
            @Override
            public void onNext(String value) {
                updateInfoCallBack.setMessage();
            }
        });

    }


}
