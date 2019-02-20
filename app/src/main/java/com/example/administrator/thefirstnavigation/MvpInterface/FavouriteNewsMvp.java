package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/12.
 */

public interface FavouriteNewsMvp {
    interface  FavouriteNewsView extends BaseView {
        void showFavouriteNews(FavouriteNewsBean favouriteNewsBean);
        void showFavouriteTopic(FavouriteTopicBean favouriteTopicBean);
    }
    interface FavouriteNewsCallBack extends HttpFinishCallback {
        void setFavouriteNews(FavouriteNewsBean favouriteNews);
        void setFavouriteTopic(FavouriteTopicBean favouriteTopic);
    }
    interface FavouriteNewsModle{

        void getFavouriteNews(String cursor,  FavouriteNewsCallBack InsertCallBack);
        void getFavouriteTopic(String cursor,FavouriteNewsCallBack InsertCallBack);
    }
}
