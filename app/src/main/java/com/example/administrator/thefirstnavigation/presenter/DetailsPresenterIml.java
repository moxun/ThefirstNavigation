package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.DetailsMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.modle.DetailsModleIml;

/**
 * Created by Administrator on 2019/1/27.
 */

public class DetailsPresenterIml<V extends DetailsMvp.DetailsView> extends ImlBasePresenter<DetailsMvp.DetailsView> implements DetailsMvp.DetailsCallBack {
    private DetailsModleIml mDetailsModleIml=new DetailsModleIml();
    public  void  getDetails(String newsid){
        if(mView!=null){
            mDetailsModleIml.getNews(newsid,this);
        }
    }
    public  void  getAbout(String newsid){
        if(mView!=null){
            mDetailsModleIml.getAbout(newsid,this);
        }
    }
    public  void  getComment(){
        if(mView!=null){
            mDetailsModleIml.getComment(this);
        }
    }
    public  void  getUserInfo(){
        if(mView!=null){
            mDetailsModleIml.getUserInfoBean(this);
        }
    }
    public  void  getDiscuss(String json){
        if(mView!=null){
            mDetailsModleIml.getDiscuss(json,this);
        }
    }
    public  void  getLike(String json){
        if(mView!=null){
            mDetailsModleIml.getLike(json,this);
        }
    }

    public void getFavourite(String json){
        if(mView!=null){
            mDetailsModleIml.getFavourite(json,this);
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
    public void setBean(DetailsBean downListNewsBean) {
        mView.showBean(downListNewsBean);
    }

    @Override
    public void setAbout(AboutBean about) {
        mView.showAbout(about);
    }

    @Override
    public void setComment(CommentBean comment) {
        mView.showComment(comment);
    }

    @Override
    public void setInFoBean(UserInfoBean userInfoBean) {
        mView.showInFoBean(userInfoBean);
    }

    @Override
    public void setDiscuss() {
        mView.showDiscuss();
    }

    @Override
    public void setLike() {
        mView.showLike();
    }

    @Override
    public void setFavourite() {
        mView.showFavourite();
    }
}
