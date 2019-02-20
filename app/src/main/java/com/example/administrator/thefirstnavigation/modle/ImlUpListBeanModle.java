package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.UpListNewsMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/1/17.
 */

public class ImlUpListBeanModle implements UpListNewsMvp.ListNewsModle {
    @Override
    public void getNews(String url, final UpListNewsMvp.ListNewsHttp listNewsHttp) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        listNewsHttp.setShowProgressbar();
        retorfitUnits.getNewsObservable("news/listNewsChannel").compose(RxUtils.<MainBean<UpListNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UpListNewsBean>handleResult())
                .subscribe(new BaseObserver<UpListNewsBean>(null) {
                    @Override
                    public void onNext(UpListNewsBean value) {
                        listNewsHttp.setBean(value);
                    }
                });
    }
}
