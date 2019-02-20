package com.example.administrator.thefirstnavigation.base.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 88888 on 2019/1/18.
 */

public class NewsListadapter extends FragmentPagerAdapter {

    private final ArrayList<String> mTitle;
    private final ArrayList<Fragment> mFragments;
    private final FragmentManager fm;

    public NewsListadapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> fragments) {
        super(fm);
        this.fm=fm;
        mTitle = title;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

}
