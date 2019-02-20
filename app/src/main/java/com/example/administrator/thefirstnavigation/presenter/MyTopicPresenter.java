package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.MyTopicMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.UpListNewsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.modle.MyTopicModle;

/**
 * Created by Administrator on 2019/2/3.
 */

public class MyTopicPresenter <V extends MyTopicMvp.MyTopicView> extends ImlBasePresenter<MyTopicMvp.MyTopicView> implements MyTopicMvp.MyTopicCallBack {
    private MyTopicModle mMyTopicModle=new MyTopicModle();
    public void getHot(){
        if(mView!=null){
            mMyTopicModle.getHot(this);
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
    public void setHot(HotBean hot) {
        mView.showHot(hot);
    }
}
