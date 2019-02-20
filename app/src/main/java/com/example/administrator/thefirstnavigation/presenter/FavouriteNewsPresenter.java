package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.FavouriteNewsMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;
import com.example.administrator.thefirstnavigation.modle.FavouriteNewsModle;

/**
 * Created by Administrator on 2019/2/12.
 */

public class FavouriteNewsPresenter <V extends FavouriteNewsMvp.FavouriteNewsView> extends ImlBasePresenter<FavouriteNewsMvp.FavouriteNewsView> implements FavouriteNewsMvp.FavouriteNewsCallBack {
    private FavouriteNewsModle mFavouriteNewsModle=new FavouriteNewsModle();
      public void getFavouriteNews(String cursor){
        mFavouriteNewsModle.getFavouriteNews(cursor,this);
    }
    public void getFavouriteTopic(String cursor){
        mFavouriteNewsModle.getFavouriteTopic(cursor,this);
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
    public void setFavouriteNews(FavouriteNewsBean favouriteNews) {
        mView.showFavouriteNews(favouriteNews);
    }

    @Override
    public void setFavouriteTopic(FavouriteTopicBean favouriteTopic) {
        mView.showFavouriteTopic(favouriteTopic);
    }
}
