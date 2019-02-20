package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.FiyMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/1/31.
 */

public class FiyModle implements FiyMvp.TopicModle{

    @Override
    public void getLoad(String json, final FiyMvp.TopicCallBack updateInfoCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getLoadTopic(json).compose(RxUtils.<MainBean<TopicBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<TopicBean>handleResult())
                .subscribe(new BaseObserver<TopicBean>(updateInfoCallBack) {
                    @Override
                    public void onNext(TopicBean value) {
                        updateInfoCallBack.setLoad(value);
                    }
                });
    }
}
