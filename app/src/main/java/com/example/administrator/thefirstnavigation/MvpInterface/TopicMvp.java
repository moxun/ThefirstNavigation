package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;

/**
 * Created by Administrator on 2019/1/28.
 */

public interface TopicMvp {
    interface TopicView extends BaseView {
        void  showLoad(TopicBean topicBean);
        void showRefresh(TopicBean topicBean);
    }
    interface  TopicCallBack extends HttpFinishCallback {
        void setLoad(TopicBean topicBean);
        void setRefresh(TopicBean topicBean);
    }
    interface  TopicModle{

        void getLoad(String json, TopicCallBack updateInfoCallBack);
        void getRefresh(String json,TopicCallBack topicCallBack);
    }
}
