package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.FavouriteNewsMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/2/12.
 */

public class FavouriteNewsModle implements FavouriteNewsMvp.FavouriteNewsModle {
    @Override
    public void getFavouriteNews(String cursor, final FavouriteNewsMvp.FavouriteNewsCallBack InsertCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getFavouriteNews(cursor).compose(RxUtils.<MainBean<FavouriteNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<FavouriteNewsBean>handleResult())
                .subscribe(new BaseObserver<FavouriteNewsBean>(InsertCallBack) {
                    @Override
                    public void onNext(FavouriteNewsBean value) {
                        InsertCallBack.setFavouriteNews(value);
                    }
                });
    }

    @Override
    public void getFavouriteTopic(String cursor, final FavouriteNewsMvp.FavouriteNewsCallBack InsertCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getFavouriteTopic(cursor).compose(RxUtils.<MainBean<FavouriteTopicBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<FavouriteTopicBean>handleResult())
                .subscribe(new BaseObserver<FavouriteTopicBean>(InsertCallBack) {
                    @Override
                    public void onNext(FavouriteTopicBean value) {
                       InsertCallBack.setFavouriteTopic(value);
                    }
                });
    }
}
