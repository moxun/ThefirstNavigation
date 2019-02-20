package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.MoreFollowMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.MoreFollowAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.Follow;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.MoreFollow;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.MoreFollowPresenter;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollowFragment extends BaseFragment<MoreFollowMvp.MoreFollowView, MoreFollowPresenter<MoreFollowMvp.MoreFollowView>> implements MoreFollowMvp.MoreFollowView {
    @BindView(R.id.recy_more)
    RecyclerView mRecyMore;
    private View view;
    private Unbinder unbinder;

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showHot(HotBean hotBean) {

    }

    @Override
    public void showMoreFollow(MoreFollowBean moreFollowBean) {
        Log.d("moxun", "showMoreFollow: " + moreFollowBean.getMoreFollowList().size());
        MoreFollowAdapter moreFollowAdapter = new MoreFollowAdapter(moreFollowBean.getMoreFollowList(), mActivity);
        mRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyMore.setAdapter(moreFollowAdapter);
        moreFollowAdapter.OnsetOnClickListener(new MoreFollowAdapter.setOnClickListener() {
            @Override
            public void setOnClickListener(MoreFollowBean.MoreFollowListBean followListBean) {
                Log.d("=======", "setOnClickListener: "+followListBean.isGuanzhu());
                if(!followListBean.isGuanzhu()){
                    Log.d("moxun", "setOnClickListener: ");
                    Follow follow = new Follow(Characterl.newsid, followListBean.getUserId(), "0");
                    Gson gson = new Gson();
                    String json = gson.toJson(follow);
                    presenter.getFlollow(json);
                }else{
                    Follow follow = new Follow(Characterl.newsid, followListBean.getUserId(), "1");
                    Gson gson = new Gson();
                    String json = gson.toJson(follow);
                    presenter.getFlollow(json);
                }
            }
        });
    }

    @Override
    public void showFollow() {

    }

    @Override
    protected MoreFollowPresenter<MoreFollowMvp.MoreFollowView> createPresenter() {
        return new MoreFollowPresenter<>();
    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_morefollow;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String id = arguments.getString("id");
        Log.d("moxun", "initData: " + id);
        MoreFollow moreFollow = new MoreFollow("049de01db14a4c8184faa0aca7facf8a", id, "0");
        String json = new Gson().toJson(moreFollow);
        presenter.getMoreFlollow(json);

    }




}
