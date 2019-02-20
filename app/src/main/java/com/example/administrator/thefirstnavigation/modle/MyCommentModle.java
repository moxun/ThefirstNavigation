package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.MyCommentMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MyCommentModle implements MyCommentMvp.MyCommentModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();
    @Override
    public void getMyComment(final MyCommentMvp.MyCommentCallBack classfiyCallBack) {
        classfiyCallBack.setShowProgressbar();
        mRetorfitUnits.getMyComment().compose(RxUtils.<MainBean<MyCommentBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MyCommentBean>handleResult())
                .subscribe(new BaseObserver<MyCommentBean>(classfiyCallBack) {
                    @Override
                    public void onNext(MyCommentBean value) {
                        classfiyCallBack.setMyComment(value);
                    }
                });
    }
}
