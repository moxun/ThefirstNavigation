package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.modle.SearchModle;
import com.example.administrator.thefirstnavigation.modle.TopicModleIml;

/**
 * Created by Administrator on 2019/1/28.
 */

public class TopicPresenter <V extends TopicMvp.TopicView> extends ImlBasePresenter<TopicMvp.TopicView> implements TopicMvp.TopicCallBack {
    private TopicModleIml mTopicModleIml=new TopicModleIml();
    public void getLoad(String json){
        if(mView!=null){
            mTopicModleIml.getLoad(json,this);
        }
    }
    public void getRefresh(String json){
        if(mView!=null){
            mTopicModleIml.getRefresh(json,this);
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

    @Override
    public void setRefresh(TopicBean topicBean) {
        mView.showRefresh(topicBean);
    }
}
