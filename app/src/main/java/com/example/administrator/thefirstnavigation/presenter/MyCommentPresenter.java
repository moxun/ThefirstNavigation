package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.MoreFollowMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.MyCommentMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;
import com.example.administrator.thefirstnavigation.modle.MyCommentModle;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MyCommentPresenter  <V extends MyCommentMvp.MyCommentView> extends ImlBasePresenter<MyCommentMvp.MyCommentView> implements MyCommentMvp.MyCommentCallBack {
    private MyCommentModle mMyCommentModle=new MyCommentModle();
    public void getMyComment(){
        if(mView!=null){
            mMyCommentModle.getMyComment(this);
        }
    }

    @Override
    public void setShowProgressbar() {
        mView.showProgressbar();
    }

    @Override
    public void setHideProgressbar() {
        mView.hideProgressbar();
    }

    @Override
    public void setError(String error) {
        mView.showError(error);
    }

    @Override
    public void setMyComment(MyCommentBean myComment) {
        mView.showMyComment(myComment);
    }
}
