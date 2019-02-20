package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.SearchMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.modle.SearchModle;

/**
 * Created by Administrator on 2019/1/24.
 */

public class SearchPresenter<V extends SearchMvp.SearchView> extends ImlBasePresenter<SearchMvp.SearchView> implements SearchMvp.SearchCallBack {
    private SearchModle mSearchModle=new SearchModle();
    public void getSearchBean(String json){
        if(mView!=null){
            mSearchModle.getSearch(json,this);
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
    public void setSearch(UpdaterNewsBean uploadHead) {
        mView.showSearch(uploadHead);
    }
}
