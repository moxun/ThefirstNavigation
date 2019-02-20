package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.NewsListBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.modle.DownListNewsModleIml;

/**
 * Created by Administrator on 2019/1/21.
 */

public class DownNewsPresenterIml<V extends DownListNewsMvp.DownListNewsView> extends ImlBasePresenter<DownListNewsMvp.DownListNewsView> implements DownListNewsMvp.DownListNewsCallBack {
    private DownListNewsModleIml mDownListNewsModleIml=new DownListNewsModleIml();
    public void getDown(String string){
        if(mView!=null){
            mDownListNewsModleIml.getNews(string,this);
        }
    }
    public void getUp(String string){
        if(mView!=null){
            mDownListNewsModleIml.getSearch(string,this);
        }
    }
    @Override
    public void setShowProgressbar() {
        mView.showProgressbar();
    }

    @Override
    public void setHideProgressbar() {
        mView.hideProgressbar();
    }

    @Override
    public void setError(String error) {
        mView.showError(error);
    }

    @Override
    public void setBean(UpdaterNewsBean downListNewsBean) {
        mView.showBean(downListNewsBean);
    }

    @Override
    public void setSearch(UpdaterNewsBean downListNewsBean) {
        mView.search(downListNewsBean);
    }
}
