package com.example.administrator.thefirstnavigation.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.MoreFrgmentAdapter;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.fragment.CommentFragment;
import com.example.administrator.thefirstnavigation.fragment.LikeFragment;
import com.example.administrator.thefirstnavigation.fragment.NotifyFragment;
import com.example.administrator.thefirstnavigation.units.NoScrollViewPager;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/2/14.
 */

public class ListNotifyActivity extends SimpleActivity {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.ViewPager)
    NoScrollViewPager mViewPager;
    private ArrayList<Fragment> mFragments=new ArrayList<>();
    private ArrayList<String> mTitle=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        setToolBar(mToolBar,"消息通知");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.red));
        NotifyFragment SystemFragment = new NotifyFragment();
        CommentFragment CommentFragment = new CommentFragment();
        NotifyFragment FollowFragment = new NotifyFragment();
        LikeFragment LikeFragment = new LikeFragment();
        Bundle systembundle = new Bundle();
        systembundle.putString("type","0");
        SystemFragment.setArguments(systembundle);

        Bundle followbundle = new Bundle();
        followbundle.putString("type","1");
        FollowFragment.setArguments(followbundle);

        mFragments.add(SystemFragment);
        mFragments.add(CommentFragment);
        mFragments.add(FollowFragment);
        mFragments.add(LikeFragment);
        mTitle.add("通知");
        mTitle.add("评论我");
        mTitle.add("关注我");
        mTitle.add("点赞我");
        mViewPager.setNoScroll(true);
        MoreFrgmentAdapter moreFrgmentAdapter = new MoreFrgmentAdapter(getSupportFragmentManager(), mFragments, mTitle);
        mViewPager.setAdapter(moreFrgmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_listnotify;
    }


}
