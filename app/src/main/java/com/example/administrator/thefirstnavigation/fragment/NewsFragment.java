package com.example.administrator.thefirstnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.DownListNewsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.DetailsActivity;
import com.example.administrator.thefirstnavigation.adapter.ShowNewListadapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.NewsListBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.DownNews;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.DownNewsPresenterIml;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2019/1/20.
 */

public class NewsFragment extends BaseFragment<DownListNewsMvp.DownListNewsView, DownNewsPresenterIml<DownListNewsMvp.DownListNewsView>> implements DownListNewsMvp.DownListNewsView {
    @BindView(R.id.channel_recy_more)
    RecyclerView mChannelRecyMore;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    private View view;
    private Unbinder unbinder;
    private String mId;
    private String cursor = "0";
    List<UpdaterNewsBean.NewListBean> newList = new ArrayList<>();
    private ShowNewListadapter mShowNewListadapter;
    private boolean isLoadingMore = false;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        mId = arguments.getString("id");
        Gson gson = new Gson();
        DownNews downNews = new DownNews(Characterl.newsid, mId, cursor);
        String json = gson.toJson(downNews);
        Log.d(TAG, "initData: "+json);
        presenter.getDown(json);
        Log.d("down", "initData: " + json);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mChannelRecyMore.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mChannelRecyMore.addItemDecoration(decoration);
        mShowNewListadapter = new ShowNewListadapter(newList);
        mChannelRecyMore.setAdapter(mShowNewListadapter);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Gson gson = new Gson();
                DownNews downNews = new DownNews(Characterl.newsid, mId, cursor);
                String json = gson.toJson(downNews);
                Log.d(TAG, "onRefresh: "+json);
                presenter.getUp(json);
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

                    Gson gson = new Gson();
                    DownNews downNews = new DownNews(Characterl.newsid, mId, cursor);
                    String json = gson.toJson(downNews);
                    Log.d(TAG, "onScrolled: " + json);
                    presenter.getDown(json);

                }

            }
        });
        mShowNewListadapter.OnsetOnClickListener(new ShowNewListadapter.setOnClickListener() {
            @Override
            public void setOnClickListener(UpdaterNewsBean.NewListBean newsListBean) {
                Intent intent = new Intent(mActivity, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("bean",newsListBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showBean(UpdaterNewsBean downListNewsBean) {

        List<UpdaterNewsBean.NewListBean> newLis = downListNewsBean.getNewList();
        cursor = downListNewsBean.getCursor();
        mShowNewListadapter.setData(newLis, cursor);
        Log.d("mmmmmmmmmmmmmmmmmmmmmmm", "showBean: " + downListNewsBean.getNewList().get(0).getTitle());


    }

    @Override
    public void search(UpdaterNewsBean downListNewsBean) {
        mShowNewListadapter.setSearch(downListNewsBean.getNewList());
        mChannelRecyMore.getLayoutManager().scrollToPosition(0);
        cursor=downListNewsBean.getMinCursor();
        Log.d("__________", "showBean: " + downListNewsBean.getNewList().get(0).getIsTop());

    }

    @Override
    protected DownNewsPresenterIml<DownListNewsMvp.DownListNewsView> createPresenter() {
        return new DownNewsPresenterIml<>();
    }
}
