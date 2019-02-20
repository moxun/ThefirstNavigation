package com.example.administrator.thefirstnavigation.base.activity;


import android.app.ActivityThread;
import android.util.Log;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.Window;
import android.widget.PopupWindow;

import com.example.administrator.thefirstnavigation.base.presenter.BasePresenter;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.units.DaalogHelper;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;

/**
 * Created by Administrator on 2018/12/21.
 */

public abstract class BaseActicity<V,P extends BasePresenter<V>> extends SimpleActivity implements BaseView{

    public P mPresentser;

    @Override
    public void viewCreated() {
        super.viewCreated();
        mPresentser = createPresenter();
        if(mPresentser!=null){
            mPresentser.attachView((V) this);
        }
    }
    //创建子类的P层对象
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresentser != null) {
            mPresentser.detachView();
            mPresentser=null;
        }
    }

    @Override
    public void showProgressbar() {
        DaalogHelper.showProgressDlg(this,"正在加载数据");
    }

    @Override
    public void showError(String error) {
        Log.d("moxun", "showError: "+error);
        DialogBuilder dialogBuilder = new DialogBuilder(this);
        dialogBuilder.title("警告！")
                .message(error)
                .sureText("确定")
                .setSureOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })

                .build().show();
    }
}
