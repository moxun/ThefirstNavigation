package com.example.administrator.thefirstnavigation.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/1/28.
 */

public class TopicAdapter extends FragmentPagerAdapter {

    private final ArrayList<String> list;
    private final ArrayList<Fragment> mData;
    private final FragmentManager fm;

    public TopicAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> fragments) {

        super(fm);
        this.fm=fm;
        this.list=title;
        this.mData=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
    @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            fm.beginTransaction().show(fragment).commitAllowingStateLoss();
            return fragment;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Fragment fragment = mData.get(position);
            fm.beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
}
