package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.MineTopicMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/15.
 */

public class MineTopicModle implements MineTopicMvp.MineTopicModle {
    @Override
    public void getMineTopic(String cursor, final MineTopicMvp.MineTopicCallBack updateInfoCallBack) {
        RetorfitUnits retorfitUnits=new RetorfitUnits();
        updateInfoCallBack.setShowProgressbar();
        retorfitUnits.getMineTopic(cursor).compose(RxUtils.<MainBean<MineTopicBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MineTopicBean>handleResult())
                .subscribe(new BaseObserver<MineTopicBean>(updateInfoCallBack) {
                    @Override
                    public void onNext(MineTopicBean value) {
                        updateInfoCallBack.setMineTopic(value);
                    }
                });
    }
}
