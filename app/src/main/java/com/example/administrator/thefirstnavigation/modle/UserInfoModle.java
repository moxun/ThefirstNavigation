package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.UserInfoMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
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
 * Created by Administrator on 2019/2/11.
 */

public class UserInfoModle implements UserInfoMvp.UserInfoModle {
    @Override
    public void getHot(final UserInfoMvp.UserInfoCallBack classfiyCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getUserCenter().compose(RxUtils.<MainBean<UserCenterBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserCenterBean>handleResult())
                .subscribe(new BaseObserver<UserCenterBean>(classfiyCallBack) {
                    @Override
                    public void onNext(UserCenterBean value) {
                        classfiyCallBack.setHot(value);
                    }
                });
    }

    @Override
    public void getUpdateInfo(String json, final UserInfoMvp.UserInfoCallBack userInfoCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getshowUpdateInfo(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
                .flatMap(new Function<MainBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final MainBean mainBean) throws Exception {
                        if (mainBean.getCode() != 0) {
                            return Observable.error(new SeveryEcception(mainBean.getCode(), mainBean.getMessage()));
                        } else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(userInfoCallBack) {
            @Override
            public void onNext(String value) {
                userInfoCallBack.setUpdateInfo();
            }
        });
    }

    @Override
    public void getUserInfo(final UserInfoMvp.UserInfoCallBack callBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getUserInfo().compose(RxUtils.<MainBean<UserInfoBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserInfoBean>handleResult())
                .subscribe(new BaseObserver<UserInfoBean>(callBack) {
                    @Override
                    public void onNext(UserInfoBean value) {
                        callBack.setUserInfo(value);
                    }
                });
    }

    @Override
    public void getUploadHead(File file, final UserInfoMvp.UserInfoCallBack uploadHeadCallBack) {
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
}
