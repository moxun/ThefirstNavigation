package com.example.administrator.thefirstnavigation.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/12/21.
 */

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder mBind;
    private Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayoutID());
        mBind = ButterKnife.bind(this);
        mActivity = this;
        viewCreated();
        initData();
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getLocalClassName()); //手动统计页面("SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this); //统计时长
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getLocalClassName()); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
        MobclickAgent.onPause(this);
    }

    public void viewCreated() {

    }
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected abstract void initData();

    public abstract int createLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBind!=null){
            mBind.unbind();
        }
    }
}
