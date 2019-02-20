package com.example.administrator.thefirstnavigation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/21.
 */

public class NavigationAdapter extends FragmentPagerAdapter {

    private final FragmentManager fm;
    private ArrayList<Fragment> fragments;

    public NavigationAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fm=fm;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            fm.beginTransaction().show(fragment).commitAllowingStateLoss();
            return fragment;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Fragment fragment = fragments.get(position);
            fm.beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
}
