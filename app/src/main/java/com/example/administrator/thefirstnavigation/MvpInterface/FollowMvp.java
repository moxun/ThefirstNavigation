package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;

/**
 * Created by Administrator on 2019/2/13.
 */

public interface FollowMvp {
    interface FollowView extends BaseView {
        void  showFollow(FollowBean followBean);

    }
    interface  FollowCallBack extends HttpFinishCallback {
        void setFollow(FollowBean follow);

    }
    interface  FollowModle{

        void getFollow( FollowCallBack updateInfoCallBack);

    }
}
