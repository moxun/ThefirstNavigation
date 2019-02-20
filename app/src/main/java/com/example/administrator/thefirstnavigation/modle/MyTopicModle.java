package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.MyTopicMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/3.
 */

public class MyTopicModle implements MyTopicMvp.MyTopicModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();

    @Override
    public void getHot(final MyTopicMvp.MyTopicCallBack classfiyCallBack) {
        classfiyCallBack.setShowProgressbar();
        mRetorfitUnits.getHot().compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>(classfiyCallBack) {
                    @Override
                    public void onNext(HotBean value) {
                        classfiyCallBack.setHot(value);
                    }
                });
    }
}
