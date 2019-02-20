package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.UpListNewsMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.modle.ImlUpListBeanModle;

/**
 * Created by Administrator on 2019/1/17.
 */

public class ImlUpNewsPresenter<V extends UpListNewsMvp.ListNewsView> extends ImlBasePresenter<UpListNewsMvp.ListNewsView> implements UpListNewsMvp.ListNewsHttp {

        private ImlUpListBeanModle mImlUpListBeanModle=new ImlUpListBeanModle();

        public void getUpNews(String string){
            if(mView!=null){
                mImlUpListBeanModle.getNews(string,this);
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
        if(mView!=null){
            mView.showError(error);
        }
    }

    @Override
    public void setBean(UpListNewsBean upListNewsBean) {
        if(mView!=null){
            mView.showBean(upListNewsBean);
        }
    }
}
