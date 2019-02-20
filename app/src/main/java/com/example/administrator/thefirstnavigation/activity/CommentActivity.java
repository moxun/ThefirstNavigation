package com.example.administrator.thefirstnavigation.activity;


import android.content.Intent;
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
import com.example.administrator.thefirstnavigation.fragment.CommentNewsFragment;
import com.example.administrator.thefirstnavigation.fragment.CommentTopicFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/2/13.
 */

public class CommentActivity extends SimpleActivity {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.ViewPager)
    ViewPager mViewPager;
    private ArrayList<Fragment> mFragments=new ArrayList<>();
    private ArrayList<String> mStrings=new ArrayList<>();
    private MoreFrgmentAdapter mMoreFrgmentAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        Intent intent = getIntent();
        String head = intent.getStringExtra("head");
        String name = intent.getStringExtra("name");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
        setToolBar(mToolBar,"我的评论");
        CommentNewsFragment commentNewsFragment = new CommentNewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("head",head);
        bundle.putString("name",name);
        commentNewsFragment.setArguments(bundle);
        mFragments.add(commentNewsFragment);
        CommentTopicFragment commentTopicFragment = new CommentTopicFragment();
        commentTopicFragment.setArguments(bundle);
        mFragments.add(commentTopicFragment);
        mStrings.add("咨询");
        mStrings.add("话题");
        mMoreFrgmentAdapter = new MoreFrgmentAdapter(getSupportFragmentManager(), mFragments, mStrings);
        mViewPager.setAdapter(mMoreFrgmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_comment;
    }


}
