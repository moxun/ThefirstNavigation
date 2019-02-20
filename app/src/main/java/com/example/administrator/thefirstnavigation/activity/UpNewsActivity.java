package com.example.administrator.thefirstnavigation.activity;

import android.util.Log;

import com.example.administrator.thefirstnavigation.MvpInterface.UpListNewsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.presenter.ImlUpNewsPresenter;

/**
 * Created by Administrator on 2019/1/17.
 */

public class UpNewsActivity  extends BaseActicity<UpListNewsMvp.ListNewsView,ImlUpNewsPresenter<UpListNewsMvp.ListNewsView>> implements  UpListNewsMvp.ListNewsView{


    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showBean(UpListNewsBean upListNewsBean) {
        Log.d("moxun", "showBean: "+upListNewsBean.getNewsChannelList().get(0).getChannelName());
    }

    @Override
    protected ImlUpNewsPresenter<UpListNewsMvp.ListNewsView> createPresenter() {
        return new ImlUpNewsPresenter<>();
    }

    @Override
    protected void initData() {
        mPresentser.getUpNews("news/listNewsChannel");
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_main;
    }
}
