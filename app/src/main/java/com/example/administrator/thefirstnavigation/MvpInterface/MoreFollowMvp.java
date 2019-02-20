package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;

/**
 * Created by Administrator on 2019/2/13.
 */

public interface MoreFollowMvp {
    interface  MoreFollowView extends BaseView {
        void showHot(HotBean hotBean);
        void showMoreFollow(MoreFollowBean moreFollowBean);
        void showFollow();
    }
    interface MoreFollowCallBack extends HttpFinishCallback {
        void setHot(HotBean hotBean);
        void setMoreFollow(MoreFollowBean moreFollow);
        void setFollow();
    }
    interface MoreFollowModle{

        void gethot(MoreFollowCallBack moreFollowCallBack);
        void getMoreFollow(String json,MoreFollowCallBack moreFollowCallBack);
        void getFollow(String json,MoreFollowCallBack moreFollowCallBack);

    }
}
