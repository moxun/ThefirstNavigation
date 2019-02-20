package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;

import java.io.File;

/**
 * Created by Administrator on 2019/1/18.
 */

public interface UploadHeadImageMvp {
    interface UploadHeadView extends BaseView{
        void  showUploadHead(UploadHeadImageBean uploadHeadImageBean);
        void showMessage();
    }
    interface UploadHeadCallBack extends HttpFinishCallback{
        void setUploadHead(UploadHeadImageBean uploadHead);
        void setMessage();
    }
    interface UploadHeadModle{
        void getUploadHead(File file,UploadHeadCallBack  uploadHeadCallBack);
        void getUpdateInfo(String json, UploadHeadCallBack  updateInfoCallBack);
    }
}
