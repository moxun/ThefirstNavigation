package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.FollowMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FollowModle implements FollowMvp.FollowModle {
    @Override
    public void getFollow(final FollowMvp.FollowCallBack updateInfoCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getFollow().compose(RxUtils.<MainBean<FollowBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<FollowBean>handleResult())
                .subscribe(new BaseObserver<FollowBean>(updateInfoCallBack) {
                    @Override
                    public void onNext(FollowBean value) {
                        updateInfoCallBack.setFollow(value);
                    }
                });
    }
}
