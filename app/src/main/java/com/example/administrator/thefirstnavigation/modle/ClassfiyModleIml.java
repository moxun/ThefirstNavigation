package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/1/31.
 */

public class ClassfiyModleIml implements ClassfiyMvp.ClassfiyModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();
    @Override
    public void getClassfiy(final ClassfiyMvp.ClassfiyCallBack classfiyCallBack) {
        classfiyCallBack.setShowProgressbar();
        mRetorfitUnits.getHot().compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>(classfiyCallBack) {
                    @Override
                    public void onNext(HotBean value) {
                        classfiyCallBack.setHot(value);
                    }
                });
    }

    @Override
    public void getTopicSearch(String json, final ClassfiyMvp.ClassfiyCallBack classfiyCallBack) {

        mRetorfitUnits.getTopicSearch(json).compose(RxUtils.<MainBean<SearchBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<SearchBean>handleResult())
                .subscribe(new BaseObserver<SearchBean>(classfiyCallBack) {
                    @Override
                    public void onNext(SearchBean value) {
                        classfiyCallBack.setTopicSearch(value);
                    }
                });
    }
}
