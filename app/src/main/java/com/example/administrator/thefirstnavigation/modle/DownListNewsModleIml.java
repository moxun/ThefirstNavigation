package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.NewsListBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/1/21.
 */

public class DownListNewsModleIml implements DownListNewsMvp.DownListNewsModle {
    @Override
    public void getNews(String json, final DownListNewsMvp.DownListNewsCallBack downListNewsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        downListNewsCallBack.setShowProgressbar();
        retorfitUnits.getDownNews(json).compose(RxUtils.<MainBean<UpdaterNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UpdaterNewsBean>handleResult())
                .subscribe(new BaseObserver<UpdaterNewsBean>(downListNewsCallBack) {
                    @Override
                    public void onNext(UpdaterNewsBean value) {
                        downListNewsCallBack.setBean(value);
                    }
                })         ;

    }

    @Override
    public void getSearch(String json, final DownListNewsMvp.DownListNewsCallBack downListNewsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();

        retorfitUnits.getUpNews(json).compose(RxUtils.<MainBean<UpdaterNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UpdaterNewsBean>handleResult())
                .subscribe(new BaseObserver<UpdaterNewsBean>(downListNewsCallBack) {
                    @Override
                    public void onNext(UpdaterNewsBean value) {
                        downListNewsCallBack.setSearch(value);
                    }
                });
    }


}
