package com.example.administrator.thefirstnavigation.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFrgmentAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> mList;
    private final ArrayList<String> mData;
    private final FragmentManager fm;

    public MoreFrgmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {

        super(fm);
        this.fm=fm;
        this.mList=fragments;
        this.mData=strings;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position);
    }
    @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            fm.beginTransaction().show(fragment).commitAllowingStateLoss();
            return fragment;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Fragment fragment = mList.get(position);
            fm.beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
}
