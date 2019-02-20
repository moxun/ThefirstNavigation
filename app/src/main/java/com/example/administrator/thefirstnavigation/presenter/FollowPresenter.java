package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.FollowMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.InsertMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.Follow;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.example.administrator.thefirstnavigation.modle.FollowModle;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FollowPresenter  <V extends FollowMvp.FollowView> extends ImlBasePresenter<FollowMvp.FollowView> implements FollowMvp.FollowCallBack {
    private FollowModle mFollowModle=new FollowModle();
    public  void fetFollow(){
        if(mView!=null){
            mFollowModle.getFollow(this);
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
    public void setFollow(FollowBean follow) {
        mView.showFollow(follow);
    }
}
