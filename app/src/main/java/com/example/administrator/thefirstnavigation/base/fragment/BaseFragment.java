package com.example.administrator.thefirstnavigation.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.administrator.thefirstnavigation.base.presenter.BasePresenter;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.units.DaalogHelper;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;


/**
 * Created by Administrator on 2018/12/21.
 */

public abstract class BaseFragment<V,P extends BasePresenter<V>>  extends  SimpleFragment implements BaseView{
    public P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.detachView();
            presenter=null;
        }
        super.onDestroyView();
    }

    @Override
    public void showProgressbar() {
        DaalogHelper.showProgressDlg(mActivity,"正在加载....");
    }

    @Override
    public void showError(String error) {
        DialogBuilder dialogBuilder = new DialogBuilder(mActivity);
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
