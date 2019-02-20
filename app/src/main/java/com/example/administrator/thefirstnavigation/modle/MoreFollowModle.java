package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.MoreFollowMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollowModle implements MoreFollowMvp.MoreFollowModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();
    @Override
    public void gethot(final MoreFollowMvp.MoreFollowCallBack moreFollowCallBack) {
        moreFollowCallBack.setShowProgressbar();
        mRetorfitUnits.getHot().compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>(moreFollowCallBack) {
                    @Override
                    public void onNext(HotBean value) {
                        moreFollowCallBack.setHot(value);
                    }
                });
    }

    @Override
    public void getMoreFollow(String json, final MoreFollowMvp.MoreFollowCallBack moreFollowCallBack) {
        moreFollowCallBack.setShowProgressbar();
        mRetorfitUnits.getMoreFollow(json).compose(RxUtils.<MainBean<MoreFollowBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MoreFollowBean>handleResult())
                .subscribe(new BaseObserver<MoreFollowBean>(moreFollowCallBack) {
                    @Override
                    public void onNext(MoreFollowBean value) {
                        moreFollowCallBack.setMoreFollow(value);
                    }
                });
    }

    @Override
    public void getFollow(String json, final MoreFollowMvp.MoreFollowCallBack moreFollowCallBack) {
        moreFollowCallBack.setShowProgressbar();
        mRetorfitUnits.getFollow(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
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
                }).subscribe(new BaseObserver<String>(moreFollowCallBack) {
            @Override
            public void onNext(String value) {
                moreFollowCallBack.setFollow();
            }
        });
    }
}
