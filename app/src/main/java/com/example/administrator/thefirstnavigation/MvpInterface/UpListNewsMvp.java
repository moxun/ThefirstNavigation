package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;

/**
 * Created by Administrator on 2019/1/17.
 */

public interface UpListNewsMvp{
    interface ListNewsView extends  BaseView{
        void  showBean(UpListNewsBean upListNewsBean);
    }
    interface ListNewsHttp extends HttpFinishCallback{
        void setBean(UpListNewsBean upListNewsBean);
    }
    interface ListNewsModle{
        void getNews(String url,ListNewsHttp listNewsHttp);
    }

}
