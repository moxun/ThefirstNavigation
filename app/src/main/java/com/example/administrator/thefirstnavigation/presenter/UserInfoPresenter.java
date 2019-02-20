package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.UploadHeadImageMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.UserInfoMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.modle.UserInfoModle;

import java.io.File;

/**
 * Created by Administrator on 2019/2/11.
 */

public class UserInfoPresenter<V extends UserInfoMvp.UserInfoView> extends ImlBasePresenter<UserInfoMvp.UserInfoView> implements UserInfoMvp.UserInfoCallBack {
    private UserInfoModle mUserInfoModle=new UserInfoModle();
    public void getUserInfo(){
        if(mView!=null){
            mUserInfoModle.getHot(this);
        }
    }
    public void getUpdateInfo(String json){
        if(mView!=null){
            mUserInfoModle.getUpdateInfo(json,this);
        }
    }
    public void getInfo(){
        if(mView!=null){
            mUserInfoModle.getUserInfo(this);
        }
    }
    public  void getUploadHead(File file){
        if(mView!=null){
            mUserInfoModle.getUploadHead(file,this);
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
    public void setHot(UserCenterBean hot) {
        mView.showHot(hot);
    }

    @Override
    public void setUpdateInfo() {
        mView.showUpdateInfo();
    }

    @Override
    public void setUserInfo(UserInfoBean userInfo) {
        mView.showUserInfo(userInfo);
    }

    @Override
    public void setUploadHead(UploadHeadImageBean uploadHeadImageBean) {
        mView.showUploadHead(uploadHeadImageBean);
    }
}
