package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.NotifyMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/14.
 */

public class NotifyModle implements NotifyMvp.NotifyModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();
    @Override
    public void getNotify(final NotifyMvp.NotifyCallBack classfiyCallBack) {
        classfiyCallBack.setShowProgressbar();
        mRetorfitUnits.getNoifty().compose(RxUtils.<ListNoiftyBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ListNoiftyBean>(classfiyCallBack) {
                    @Override
                    public void onNext(ListNoiftyBean value) {
                        classfiyCallBack.setNotify(value);
                    }
                });
    }
}
