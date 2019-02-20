package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;

/**
 * Created by Administrator on 2019/1/31.
 */

public interface FiyMvp {
    interface TopicView extends BaseView {
        void  showLoad(TopicBean topicBean);

    }
    interface  TopicCallBack extends HttpFinishCallback {
        void setLoad(TopicBean topicBean);

    }
    interface  TopicModle{

        void getLoad(String json, TopicCallBack updateInfoCallBack);

    }
}
