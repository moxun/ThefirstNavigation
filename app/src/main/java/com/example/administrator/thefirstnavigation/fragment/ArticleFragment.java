package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.SearchMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.ShowNewListadapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.SearchBean;
import com.example.administrator.thefirstnavigation.presenter.SearchPresenter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/24.
 */

public class ArticleFragment extends BaseFragment<SearchMvp.SearchView, SearchPresenter<SearchMvp.SearchView>> implements SearchMvp.SearchView {

    @BindView(R.id.channel_recy_more)
    RecyclerView mChannelRecyMore;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    private String mCurso = "0";
    private ShowNewListadapter mShowNewListadapter;
    private LinearLayoutManager mLinearLayoutManager;
    private View view;
    private Unbinder unbinder;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_article;
    }





    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getDate(String string){
        Log.e("duanxq", "getDate: "+string);
        SearchBean searchBean = new SearchBean(string, mCurso);
        Gson gson = new Gson();
        String json = gson.toJson(searchBean);
        if(presenter!=null){

            presenter.getSearchBean(json);
        }
    }

    @Override
    protected void initData() {
        /*Bundle arguments = getArguments();
        String search = arguments.getString("search");
        Log.d("moxun", "initData: " + search);*/

        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        List<UpdaterNewsBean.NewListBean> listBeans = new ArrayList<>();
        mShowNewListadapter = new ShowNewListadapter(listBeans);
        mLinearLayoutManager = new LinearLayoutManager(mActivity);
        mChannelRecyMore.setLayoutManager(mLinearLayoutManager);
        mChannelRecyMore.setAdapter(mShowNewListadapter);
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showSearch(UpdaterNewsBean uploadHeadImageBean) {
        mShowNewListadapter.mData.clear();
        Log.d("moxun", "showSearch: " + uploadHeadImageBean.getCursor());
        mShowNewListadapter.setData(uploadHeadImageBean.getNewList(),mCurso);
    }

    @Override
    protected SearchPresenter<SearchMvp.SearchView> createPresenter() {
        return new SearchPresenter<>();
    }




}
