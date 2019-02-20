package com.example.administrator.thefirstnavigation.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/12/21.
 */

public abstract class SimpleFragment extends Fragment {
    public Context context;
    public Activity mActivity;
    public Unbinder unbinder;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (Activity) context;
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(createLayoutId(), null);
        Log.d("执行的逻辑", "onCreateView: "+"执行了");
        return view;
    }

    public abstract int createLayoutId();

    //onCreateView是创建的时候调用，onViewCreated是在onCreateView后被触发的事件，前后关系
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder= ButterKnife.bind(this,view);
        initData();
    }

    protected abstract void initData();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            loading();
        }
    }

    /**
     * TODO 懒加载方法 需要就重写
     */
    public void loading() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("MainScreen"); //统计页面("MainScreen"为页面名称，可自定义)
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("MainScreen");
    }

}
