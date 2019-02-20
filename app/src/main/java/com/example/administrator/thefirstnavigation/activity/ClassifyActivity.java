package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.administrator.thefirstnavigation.MvpInterface.FiyMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.TopicRecyAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.Topic;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;
import com.example.administrator.thefirstnavigation.presenter.FiyPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2019/1/31.
 */

public class ClassifyActivity extends BaseActicity<FiyMvp.TopicView, FiyPresenter<FiyMvp.TopicView>> implements FiyMvp.TopicView {
    private static final String TAG = "moxun";
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.class_recy)
    RecyclerView mClassRecy;
    private TopicRecyAdapter mTopicRecyAdapter;

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showLoad(TopicBean topicBean) {
        Log.d(TAG, "showLoad: "+topicBean.getTopicList().size());
        mTopicRecyAdapter.addAll(topicBean.getTopicList(),0);
    }

    @Override
    protected FiyPresenter<FiyMvp.TopicView> createPresenter() {
        return new FiyPresenter<>();
    }

    @Override
    protected void initData() {
        
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String tag = intent.getStringExtra("tag");
        setToolBar(mToolBar,tag);
        List<TopicBean.TopicListBean> topicListBeans=new ArrayList<>();
        mTopicRecyAdapter = new TopicRecyAdapter(topicListBeans,this);
        mClassRecy.setLayoutManager(new LinearLayoutManager(this));
        mClassRecy.setAdapter(mTopicRecyAdapter);
        Log.d(TAG, "initData: "+id);
        String cursor = "0";
        Topic topic = new Topic("2", cursor, Characterl.newsid, id);
        Gson gson = new Gson();
        String json = gson.toJson(topic);
        mPresentser.getLoad(json);

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_classfiy;
    }


}
