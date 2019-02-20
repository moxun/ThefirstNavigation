package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.DetailsMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;
import com.example.administrator.thefirstnavigation.modle.ClassfiyModleIml;

/**
 * Created by Administrator on 2019/1/31.
 */

public class ClassfiyPresenter<V extends ClassfiyMvp.ClassfiyView> extends ImlBasePresenter<ClassfiyMvp.ClassfiyView> implements ClassfiyMvp.ClassfiyCallBack {
    private ClassfiyModleIml mClassfiyModleIml=new ClassfiyModleIml();
    public void getHot(){
        if(mView!=null){
            mClassfiyModleIml.getClassfiy(this);
        }

    }
    public void getSearch(String json){
        if(mView!=null){
            mClassfiyModleIml.getTopicSearch(json,this);
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

    @Override
    public void setTopicSearch(SearchBean search) {
        mView.showTopicSearch(search);
    }
}
