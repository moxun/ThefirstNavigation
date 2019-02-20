package com.example.administrator.thefirstnavigation.presenter;


import com.example.administrator.thefirstnavigation.MvpInterface.InsertMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.MoreFollowMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;
import com.example.administrator.thefirstnavigation.modle.MoreFollowModle;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollowPresenter <V extends MoreFollowMvp.MoreFollowView> extends ImlBasePresenter<MoreFollowMvp.MoreFollowView> implements MoreFollowMvp.MoreFollowCallBack {
    private MoreFollowModle mMoreFollowModle=new MoreFollowModle();
    public void getHot(){
        if(mView!=null){
            mMoreFollowModle.gethot(this);
        }

    }
    public void getMoreFlollow(String json){
        if(mView!=null){
            mMoreFollowModle.getMoreFollow(json,this);
        }
    }
    public void getFlollow(String json){
        if(mView!=null){
            mMoreFollowModle.getFollow(json,this);
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
    public void setHot(HotBean hotBean) {
        mView.showHot(hotBean);
    }

    @Override
    public void setMoreFollow(MoreFollowBean moreFollow) {
        mView.showMoreFollow(moreFollow);
    }

    @Override
    public void setFollow() {
        mView.showFollow();
    }
}
