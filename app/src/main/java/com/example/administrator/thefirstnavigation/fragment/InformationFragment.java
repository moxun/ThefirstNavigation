package com.example.administrator.thefirstnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.thefirstnavigation.MvpInterface.UpListNewsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.SearchActivity;
import com.example.administrator.thefirstnavigation.activity.SelecterActivity;
import com.example.administrator.thefirstnavigation.base.adapter.NewsListadapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.base.fragment.SimpleFragment;
import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.presenter.ImlUpNewsPresenter;
import com.example.administrator.thefirstnavigation.units.dbunits.SelectorHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/19.
 */

public class InformationFragment extends BaseFragment<UpListNewsMvp.ListNewsView, ImlUpNewsPresenter<UpListNewsMvp.ListNewsView>> implements UpListNewsMvp.ListNewsView {
    @BindView(R.id.search)
    ImageView mSearch;
    @BindView(R.id.title)
    RelativeLayout mTitle;
    @BindView(R.id.tab_gold_main)
    TabLayout mTabGoldMain;
    @BindView(R.id.iv_gold_menu)
    ImageView mIvGoldMenu;
    @BindView(R.id.vp_gold_main)
    ViewPager mVpGoldMain;
    private View view;
    private Unbinder unbinder;
    private NewsListadapter mNewsListadapter;
    private ArrayList<String> mTitle1;
    private ArrayList<Fragment> mFragments;

    @Override
    public int createLayoutId() {
        return R.layout.newsfragment;
    }

    @Override
    protected void initData() {
        presenter.getUpNews("news/listNewsChannel");
    }


    @OnClick({R.id.search, R.id.iv_gold_menu})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
            case R.id.iv_gold_menu:
                startActivity(new Intent(mActivity, SelecterActivity.class));

                break;
        }
    }


    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showBean(UpListNewsBean upListNewsBean) {
        if (SelectorHelper.getInstance().query().size() == 0) {
            List<UpListNewsBean.NewsChannelListBean> newsChannelList = upListNewsBean.getNewsChannelList();
            for (int i = 0; i < newsChannelList.size(); i++) {
                if (i < 12) {
                    SelectorHelper.getInstance().insert(new SeclectorBean(null, newsChannelList.get(i).getChannelName(), newsChannelList.get(i).getChannelId(), true));
                } else {
                    SelectorHelper.getInstance().insert(new SeclectorBean(null, newsChannelList.get(i).getChannelName(), newsChannelList.get(i).getChannelId(), false));
                }
            }
        }
        Log.d("moxun", "showBean: " + upListNewsBean.getNewsChannelList().get(0).getChannelName());
        mTitle1 = new ArrayList<>();
        mFragments = new ArrayList<>();
        List<SeclectorBean> newsChannelList = SelectorHelper.getInstance().query();
        for (int i = 0; i < newsChannelList.size(); i++) {
            if (newsChannelList.get(i).getIsShow()) {
                String name = newsChannelList.get(i).getChannelName();
                String channelId = newsChannelList.get(i).getChannelId();
                mTitle1.add(name);
                NewsFragment newsFragment = new NewsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("id", channelId);
                newsFragment.setArguments(bundle);
                mFragments.add(newsFragment);
            }

        }
        mNewsListadapter = new NewsListadapter(getChildFragmentManager(), mTitle1, mFragments);
        mVpGoldMain.setAdapter(mNewsListadapter);
        mTabGoldMain.setupWithViewPager(mVpGoldMain);
    }

    @Override
    protected ImlUpNewsPresenter<UpListNewsMvp.ListNewsView> createPresenter() {
        return new ImlUpNewsPresenter<>();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(List<SeclectorBean> messageEvent) {
        mFragments.clear();
        mTitle1.clear();
        mTabGoldMain.removeAllTabs();

        for (int i = 0; i < messageEvent.size(); i++) {
            if (messageEvent.get(i).getIsShow()) {
                String name = messageEvent.get(i).getChannelName();
                String channelId = messageEvent.get(i).getChannelId();
                mTitle1.add(name);
                NewsFragment newsFragment = new NewsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("id", channelId);
                Log.d("lol", "Event: " + channelId);
                newsFragment.setArguments(bundle);
                mFragments.add(newsFragment);
            }

        }
        mNewsListadapter.notifyDataSetChanged();
        mNewsListadapter = new NewsListadapter(getChildFragmentManager(), mTitle1, mFragments);



        mVpGoldMain.setAdapter(mNewsListadapter);
        Log.d("fragment", "Event: "+mFragments.size());
        mTabGoldMain.setupWithViewPager(mVpGoldMain);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
