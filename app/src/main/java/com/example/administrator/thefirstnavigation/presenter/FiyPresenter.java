package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.FiyMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.modle.FiyModle;

/**
 * Created by Administrator on 2019/1/31.
 */

public class FiyPresenter <V extends FiyMvp.TopicView> extends ImlBasePresenter<FiyMvp.TopicView> implements FiyMvp.TopicCallBack {
    private FiyModle mFiyModle=new FiyModle();
    public  void getLoad(String json){
        if(mView!=null){
            mFiyModle.getLoad(json,this);
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
    public void setLoad(TopicBean topicBean) {
        mView.showLoad(topicBean);
    }
}
