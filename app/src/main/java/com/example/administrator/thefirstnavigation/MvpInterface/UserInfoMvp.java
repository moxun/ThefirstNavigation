package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;

import java.io.File;

/**
 * Created by Administrator on 2019/2/11.
 */

public interface UserInfoMvp {
    interface UserInfoView extends BaseView {
        void showHot(UserCenterBean hotBean);
        void showUpdateInfo();
        void showUserInfo(UserInfoBean userInfoBean);
        void  showUploadHead(UploadHeadImageBean uploadHeadImageBean);
    }
    interface UserInfoCallBack extends HttpFinishCallback {
        void setHot(UserCenterBean hot);
        void setUpdateInfo();
        void setUserInfo(UserInfoBean userInfo);
        void  setUploadHead(UploadHeadImageBean uploadHeadImageBean);
    }
    interface UserInfoModle{
        void getHot(UserInfoCallBack classfiyCallBack);
        void getUpdateInfo(String json,UserInfoCallBack userInfoCallBack);
        void getUserInfo(UserInfoCallBack callBack);
        void getUploadHead(File file, UserInfoCallBack  uploadHeadCallBack);
    }
}
