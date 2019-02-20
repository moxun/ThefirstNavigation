package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.UploadHeadImageMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.modle.UploadHeadModleIml;

import java.io.File;

/**
 * Created by Administrator on 2019/1/18.
 */

public class UploadHeadPresenterIml<V extends UploadHeadImageMvp.UploadHeadView> extends ImlBasePresenter<UploadHeadImageMvp.UploadHeadView> implements UploadHeadImageMvp.UploadHeadCallBack {
     private UploadHeadModleIml mUploadHeadModleIml=new UploadHeadModleIml();

     public  void getUploadHead(File file){
         if(mView!=null){
             mUploadHeadModleIml.getUploadHead(file,this);
         }
     }
    public  void getUpdate(String json){
        if(mView!=null){
            mUploadHeadModleIml.getUpdateInfo(json,this);
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
    public void setUploadHead(UploadHeadImageBean uploadHead) {
        mView.showUploadHead(uploadHead);
    }

    @Override
    public void setMessage() {
        mView.showMessage();
    }
}
