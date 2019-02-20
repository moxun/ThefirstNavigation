package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.NewsListBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;

/**
 * Created by Administrator on 2019/1/21.
 */

public interface DownListNewsMvp {
    interface DownListNewsView extends BaseView {
        void  showBean(UpdaterNewsBean downListNewsBean);
        void  search(UpdaterNewsBean downListNewsBean);
    }
    interface DownListNewsCallBack extends HttpFinishCallback {
        void setBean(UpdaterNewsBean downListNewsBean);
        void setSearch(UpdaterNewsBean downListNewsBean);
    }
    interface DownListNewsModle{
        void getNews(String json,DownListNewsCallBack downListNewsCallBack);
        void getSearch(String json,DownListNewsCallBack downListNewsCallBack);
    }
}
