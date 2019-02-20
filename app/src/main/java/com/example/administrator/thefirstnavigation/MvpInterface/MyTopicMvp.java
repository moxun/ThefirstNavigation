package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;

/**
 * Created by Administrator on 2019/2/3.
 */

public interface MyTopicMvp {
    interface  MyTopicView extends BaseView {
        void showHot(HotBean hotBean);
    }
    interface MyTopicCallBack extends HttpFinishCallback {
        void setHot(HotBean hot);
    }
    interface MyTopicModle{
        void getHot(MyTopicCallBack classfiyCallBack);

    }
}
