package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.InsertMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.MyTopicMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.modle.InsertModle;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/3.
 */

public class InsertPresenter <V extends InsertMvp.InsertView> extends ImlBasePresenter<InsertMvp.InsertView> implements InsertMvp.InsertCallBack {
    private InsertModle mInsertModle=new InsertModle();
    public void getInsert(String title, String taglist,ArrayList<File> file,String share){
        if(mView!=null){
            mInsertModle.getInsert(title,taglist,file,share,this);
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

    }

    @Override
    public void setInsert() {
        mView.showInsert();
    }
}
