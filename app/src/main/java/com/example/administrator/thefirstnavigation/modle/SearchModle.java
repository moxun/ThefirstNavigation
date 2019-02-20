package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.SearchMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.UploadHeadImageMvp;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

/**
 * Created by Administrator on 2019/1/24.
 */

public class SearchModle implements SearchMvp.SearchModle {
    @Override
    public void getSearch(String json, final SearchMvp.SearchCallBack updateInfoCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getSearch(json).compose(RxUtils.<MainBean<UpdaterNewsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UpdaterNewsBean>handleResult())
                .subscribe(new BaseObserver<UpdaterNewsBean>(updateInfoCallBack) {
                    @Override
                    public void onNext(UpdaterNewsBean value) {
                        updateInfoCallBack.setSearch(value);
                    }
                });
    }
}
