package com.example.administrator.thefirstnavigation.presenter;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.NotifyMvp;
import com.example.administrator.thefirstnavigation.base.presenter.ImlBasePresenter;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.modle.NotifyModle;

/**
 * Created by Administrator on 2019/2/14.
 */

public class NotifyPresenter<V extends NotifyMvp.NotifyView> extends ImlBasePresenter<NotifyMvp.NotifyView> implements NotifyMvp.NotifyCallBack {
    private NotifyModle mNotifyModle=new NotifyModle();
    public  void getNotify(){
        if(mView!=null){
            mNotifyModle.getNotify(this);
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
    public void setNotify(ListNoiftyBean listNoiftyBean) {
        mView.showNotify(listNoiftyBean);
    }
}
