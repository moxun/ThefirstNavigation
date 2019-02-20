package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;

/**
 * Created by Administrator on 2019/2/15.
 */

public interface MineTopicMvp  {
    interface MineTopicView extends BaseView {
        void  showMineTopic(MineTopicBean topicBean);

    }
    interface  MineTopicCallBack extends HttpFinishCallback {
        void setMineTopic(MineTopicBean topicBean);

    }
    interface  MineTopicModle{

        void getMineTopic(String cursor,MineTopicCallBack updateInfoCallBack);

    }
}
