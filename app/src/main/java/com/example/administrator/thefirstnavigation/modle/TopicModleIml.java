package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/1/28.
 */

public class TopicModleIml implements TopicMvp.TopicModle {

    @Override
    public void getLoad(String json, final TopicMvp.TopicCallBack updateInfoCallBack) {
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

    @Override
    public void getRefresh(String json, final TopicMvp.TopicCallBack topicCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getRefreshTopic(json).compose(RxUtils.<MainBean<TopicBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<TopicBean>handleResult())
                .subscribe(new BaseObserver<TopicBean>(topicCallBack) {
                    @Override
                    public void onNext(TopicBean value) {
                        topicCallBack.setLoad(value);
                    }
                });
    }
}
