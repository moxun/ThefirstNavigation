package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.TopicInFoMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicInfoBean;
import com.example.administrator.thefirstnavigation.modle.TopicInfoModleIml;

/**
 * Created by Administrator on 2019/1/29.
 */

public class TopicInfoPresenter <V extends TopicInFoMvp.TopicInFoView> extends ImlBasePresenter<TopicInFoMvp.TopicInFoView> implements TopicInFoMvp.TopicInFoCallBack {
    private TopicInfoModleIml mTopicInfoModleIml=new TopicInfoModleIml();
    public void getTopicInfo(String topic){
        if(mView!=null){
            mTopicInfoModleIml.getTopicInFo(topic,this);
        }
    }
    public void getListComment(String json){
        if(mView!=null){
            mTopicInfoModleIml.getListComment(json,this);
        }
    }
    public  void  getLike(String json){
        if(mView!=null){
            mTopicInfoModleIml.getLike(json,this);
        }
    }

    public void getFavourite(String json){
        if(mView!=null){
            mTopicInfoModleIml.getFavourite(json,this);
        }
    }
    public void getFlollow(String json){
        if(mView!=null){
            mTopicInfoModleIml.getFollow(json,this);
        }
    }
    public  void  getDiscuss(String json){
        if(mView!=null){
            mTopicInfoModleIml.getDiscuss(json,this);
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
    public void setTopicInFo(TopicInfoBean topicInFo) {
        mView.showTopicInFo(topicInFo);
    }

    @Override
    public void setListComment(ListCommentBean listComment) {
        mView.showListComment(listComment);
    }

    @Override
    public void setLike() {
        mView.showLike();
    }

    @Override
    public void setFavourite() {
        mView.showFavourite();
    }

    @Override
    public void setFollow() {
        mView.showFollow();
    }

    @Override
    public void setDiscuss() {
        mView.showDiscuss();
    }
}
