package com.example.administrator.thefirstnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.InsertTopicAvtivity;
import com.example.administrator.thefirstnavigation.adapter.TopicAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.SimpleFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/19.
 */

public class TopicFragment extends SimpleFragment {

    @BindView(R.id.TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.ViewPager)
    ViewPager mViewPager;
    @BindView(R.id.topic_ll)
    LinearLayout mTopicLl;
    private HuaTiFragment mHuaTiFragment;
    private HandpickFragment mHandpickFragment;
    private ClassifyFragment mClassifyFragment;
    private View view;
    private Unbinder unbinder;
    private TopicAdapter mTopicAdapter;

    @Override
    public int createLayoutId() {
        return R.layout.topicfragment;
    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        mHuaTiFragment = new HuaTiFragment();
        mHandpickFragment = new HandpickFragment();
        mClassifyFragment = new ClassifyFragment();

        fragments.add(mHuaTiFragment);
        fragments.add(mHandpickFragment);
        fragments.add(mClassifyFragment);

        strings.add("话题");
        strings.add("精选");
        strings.add("分类");

        mTopicAdapter = new TopicAdapter(getChildFragmentManager(), strings, fragments);
        mViewPager.setAdapter(mTopicAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 2) {
                    mTopicLl.setVisibility(View.GONE);
                } else {
                    mTopicLl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




    @OnClick(R.id.topic_ll)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.topic_ll:
                startActivity(new Intent(mActivity, InsertTopicAvtivity.class));
                break;
        }
    }
}
