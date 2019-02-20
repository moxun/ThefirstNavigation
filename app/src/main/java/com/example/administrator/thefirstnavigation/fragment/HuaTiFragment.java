package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.InsertTopicAvtivity;
import com.example.administrator.thefirstnavigation.adapter.TopicRecyAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.base.fragment.SimpleFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.DownNews;
import com.example.administrator.thefirstnavigation.bean.jsonbean.Topic;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.TopicPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2019/1/28.
 */

public class HuaTiFragment extends BaseFragment<TopicMvp.TopicView,TopicPresenter<TopicMvp.TopicView>> implements TopicMvp.TopicView, InsertTopicAvtivity.OnItemClick {
    @BindView(R.id.channel_recy_more)
    RecyclerView mChannelRecyMore;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    private View view;
    private Unbinder unbinder;
    private TopicRecyAdapter mTopicRecyAdapter;
    private String cursor="0";
    @Override
    public int createLayoutId() {
        return R.layout.fragment_huati;
    }

    @Override
    protected void initData() {
        List<TopicBean.TopicListBean> topicListBeans=new ArrayList<>();
        mTopicRecyAdapter = new TopicRecyAdapter(topicListBeans,mActivity);
        mChannelRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mChannelRecyMore.setAdapter(mTopicRecyAdapter);
        Topic topic = new Topic("0", cursor, Characterl.newsid, "");
        Gson gson = new Gson();
        String json = gson.toJson(topic);
        presenter.getLoad(json);

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTopicRecyAdapter.mList.clear();
                mTopicRecyAdapter.notifyDataSetChanged();
                Topic topic = new Topic("0", cursor, Characterl.newsid, "");
                Gson gson = new Gson();
                String json = gson.toJson(topic);
                presenter.getLoad(json);
                mSwipeRefresh.setRefreshing(false);
            }
        });
        mChannelRecyMore.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) mChannelRecyMore.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = mChannelRecyMore.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {  //还剩2个Item时加载更多
                    Topic topic = new Topic("0", cursor, Characterl.newsid, "");
                    Gson gson = new Gson();
                    String json = gson.toJson(topic);
                    presenter.getLoad(json);

                }

            }
        });
        InsertTopicAvtivity.setOnItemClick(this);
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showLoad(TopicBean topicBean) {
        cursor=topicBean.getCursor();

        Log.d("moxun", "showLoad: "+topicBean.getCursor());
        mTopicRecyAdapter.addAll(topicBean.getTopicList(),0);
    }

    @Override
    public void showRefresh(TopicBean topicBean) {
        mTopicRecyAdapter.setSearch(topicBean.getTopicList());
    }

    @Override
    protected TopicPresenter<TopicMvp.TopicView> createPresenter() {
        return new TopicPresenter<>();
    }

    @Override
    public void onItem() {
        mTopicRecyAdapter.mList.clear();
        mTopicRecyAdapter.notifyDataSetChanged();
        Topic topic = new Topic("0", "0", Characterl.newsid, "");
        Gson gson = new Gson();
        String json = gson.toJson(topic);
        presenter.getLoad(json);
    }
}
