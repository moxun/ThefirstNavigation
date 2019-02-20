package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.TopicRecyAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.Topic;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.TopicPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/28.
 */

public class HandpickFragment extends BaseFragment<TopicMvp.TopicView, TopicPresenter<TopicMvp.TopicView>> implements TopicMvp.TopicView {

    @BindView(R.id.channel_recy_more)
    RecyclerView mChannelRecyMore;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    private View view;
    private Unbinder unbinder;
    private TopicRecyAdapter mTopicRecyAdapter;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_handpick;
    }

    @Override
    protected void initData() {
        List<TopicBean.TopicListBean> topicListBeans=new ArrayList<>();
        mTopicRecyAdapter = new TopicRecyAdapter(topicListBeans,mActivity);
        mChannelRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mChannelRecyMore.setAdapter(mTopicRecyAdapter);
        Topic topic = new Topic("1", "0", Characterl.newsid, "");
        Gson gson = new Gson();
        String json = gson.toJson(topic);
        presenter.getLoad(json);
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showLoad(TopicBean topicBean) {
        mTopicRecyAdapter.addAll(topicBean.getTopicList(),2);
    }

    @Override
    public void showRefresh(TopicBean topicBean) {

    }

    @Override
    protected TopicPresenter<TopicMvp.TopicView> createPresenter() {
        return new TopicPresenter<>();
    }


}
