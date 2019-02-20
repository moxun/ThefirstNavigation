package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;

/**
 * Created by Administrator on 2019/2/13.
 */

public interface MyCommentMvp {
    interface  MyCommentView extends BaseView {
        void showMyComment(MyCommentBean myCommentBean);
    }
    interface MyCommentCallBack extends HttpFinishCallback {
        void setMyComment(MyCommentBean myComment);
    }
    interface MyCommentModle{
        void getMyComment(MyCommentCallBack classfiyCallBack);

    }
}
