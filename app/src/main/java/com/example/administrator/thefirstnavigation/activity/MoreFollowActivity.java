package com.example.administrator.thefirstnavigation.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.MoreFollowMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.MoreFrgmentAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;
import com.example.administrator.thefirstnavigation.fragment.MoreFollowFragment;
import com.example.administrator.thefirstnavigation.presenter.MoreFollowPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollowActivity extends BaseActicity<MoreFollowMvp.MoreFollowView, MoreFollowPresenter<MoreFollowMvp.MoreFollowView>> implements MoreFollowMvp.MoreFollowView {
    @BindView(R.id.toolbar_edit)
    EditText mToolbarEdit;
    @BindView(R.id.toolbar_Search)
    TextView mToolbarSearch;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tablayout)
    VerticalTabLayout mTablayout;

    @BindView(R.id.toolbar_hui)
    ImageView mToolbarHui;
    @BindView(R.id.viewPager)
    YViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mStrings = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
        mPresentser.getHot();
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_morefollow;

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showHot(HotBean hotBean) {
        Log.d("moxun", "showHot: " + hotBean.getData().size());
        for (int i = 0; i < hotBean.getData().size(); i++) {
            MoreFollowFragment moreFollowFragment = new MoreFollowFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", hotBean.getData().get(i).getId());
            moreFollowFragment.setArguments(bundle);
            mFragments.add(moreFollowFragment);
            mStrings.add(hotBean.getData().get(i).getTag());
        }
        MoreFrgmentAdapter moreFrgmentAdapter = new MoreFrgmentAdapter(getSupportFragmentManager(), mFragments, mStrings);
        mViewPager.setAdapter(moreFrgmentAdapter);
        mTablayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void showMoreFollow(MoreFollowBean moreFollowBean) {

    }

    @Override
    public void showFollow() {

    }

    @Override
    protected MoreFollowPresenter<MoreFollowMvp.MoreFollowView> createPresenter() {
        return new MoreFollowPresenter<>();
    }


    @OnClick({R.id.toolbar_Search, R.id.toolbar_hui})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.toolbar_Search:
                break;
            case R.id.toolbar_hui:
                finish();
                break;
        }
    }


}
