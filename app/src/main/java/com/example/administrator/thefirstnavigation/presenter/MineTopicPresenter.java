package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.MineTopicMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;
import com.example.administrator.thefirstnavigation.modle.MineTopicModle;

/**
 * Created by Administrator on 2019/2/15.
 */

public class MineTopicPresenter <V extends MineTopicMvp.MineTopicView> extends ImlBasePresenter<MineTopicMvp.MineTopicView> implements MineTopicMvp.MineTopicCallBack {
    private MineTopicModle mMineTopicModle=new MineTopicModle();
    public  void getMineTopic(String cursor){
        if(mView!=null){
            mMineTopicModle.getMineTopic(cursor,this);
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
    public void setMineTopic(MineTopicBean topicBean) {
        mView.showMineTopic(topicBean);
    }
}
