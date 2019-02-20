package com.example.administrator.thefirstnavigation.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.NavigationAdapter;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.fragment.FriendFragment;
import com.example.administrator.thefirstnavigation.fragment.InformationFragment;
import com.example.administrator.thefirstnavigation.fragment.MyinfoFragment;
import com.example.administrator.thefirstnavigation.fragment.TopicFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/1/19.
 */

public class InformationActivity extends SimpleActivity {
    @BindView(R.id.news)
    RadioButton mNews;
    @BindView(R.id.topic)
    RadioButton mTopic;
    @BindView(R.id.my)
    RadioButton mMy;
    @BindView(R.id.navigation_radiogroup)
    RadioGroup mNavigationRadiogroup;
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.friend)
    RadioButton mFriend;

    private MyinfoFragment myFragment;
    private TopicFragment mTopicFragment;
    private InformationFragment mNewsFragment;
    private ArrayList<Fragment> mFragments;
    private NavigationAdapter mNavigationAdapter;
    private int mIndex = 0;
    private FriendFragment mFriendFragment;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
        mFragments = new ArrayList<>();
        mNewsFragment = new InformationFragment();
        mTopicFragment = new TopicFragment();
        myFragment = new MyinfoFragment();
        mFriendFragment = new FriendFragment();
        changeImageSize();

        mFragments.add(mNewsFragment);
        mFragments.add(mTopicFragment);
        mFragments.add(mFriendFragment);
        mFragments.add(myFragment);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, mNewsFragment).commit();
        setIndexSelected(0);
        mNavigationRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.news:
                        setIndexSelected(0);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                        break;
                    case R.id.topic:
                        setIndexSelected(1);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorBackground));
                        break;
                    case R.id.friend:
                        setIndexSelected(2);
                        break;
                    case R.id.my:
                        setIndexSelected(3);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
                        break;
                }
            }
        });


//        mMyviewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
//                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
//                        break;
//                    case 1:
//
//                        StatusBarUtil.setStatusBarColor(InformationActivity.this, R.color.colorRed);
//
//                        break;
//                    case 2:
//                        StatusBarUtil.setStatusBarColor(InformationActivity.this, 0xFF283CBC);
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
    }

    private void setIndexSelected(int index) {

        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments.get(mIndex));
        //判断是否添加
        if (!mFragments.get(index).isAdded()) {
            ft.add(R.id.content, mFragments.get(index)).show(mFragments.get(index));
        } else {
            ft.show(mFragments.get(index));
        }

        ft.commit();
        //再次赋值
        mIndex = index;
        Log.d("loll", "setIndexSelected: " + mIndex + index);
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_information;
    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.drawable.information);
        drawableFirst.setBounds(0, 0, 40, 40);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mNews.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.drawable.huati);
        drawableSearch.setBounds(0, 0, 40, 40);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mTopic.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableFr = getResources().getDrawable(R.drawable.friend);
        drawableFr.setBounds(0, 0, 40, 40);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mFriend.setCompoundDrawables(null, drawableFr, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.drawable.mypreseon);
        drawableMe.setBounds(0, 0, 40, 40);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mMy.setCompoundDrawables(null, drawableMe, null, null);//只放上面
    }



}
