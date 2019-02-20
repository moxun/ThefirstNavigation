package com.example.administrator.thefirstnavigation.base.presenter;

/**
 * Created by Administrator on 2018/12/21.
 */

public interface BasePresenter<V> {
    
    //绑定view
    void attachView(V view);
    
    //解绑view
    void detachView();
}
