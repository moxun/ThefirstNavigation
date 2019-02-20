package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.MvpInterface.FollowMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.FollowAdapter;
import com.example.administrator.thefirstnavigation.adapter.FullDelDemoAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.example.administrator.thefirstnavigation.presenter.FollowPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FollowActivity extends BaseActicity<FollowMvp.FollowView, FollowPresenter<FollowMvp.FollowView>> implements FollowMvp.FollowView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.text_guanZhu)
    TextView mTextGuanZhu;
    @BindView(R.id.reList)
    RecyclerView mReList;
    private FullDelDemoAdapter mFullDelDemoAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.red));
        setToolBar(mToolbar, "");
        mPresentser.fetFollow();
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_follow;
    }


    @OnClick(R.id.text_guanZhu)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.text_guanZhu:
                startActivity(new Intent(this,MoreFollowActivity.class));
                break;
        }
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showFollow(FollowBean followBean) {
        final List<FollowBean.FollowListBean> followList = followBean.getFollowList();
        Log.d("moxun", "showFollow: " + followBean.getFollowList().get(0).getFollowId());
        mReList.setLayoutManager(new LinearLayoutManager(this));
        final FollowAdapter followAdapter = new FollowAdapter(followBean.getFollowList(), this);
        mFullDelDemoAdapter = new FullDelDemoAdapter(this,followList );
        mReList.setAdapter(mFullDelDemoAdapter);
//        followAdapter.OnsetOnClickListener(new FollowAdapter.setOnClickListener() {
//            @Override
//            public void setOnClickListener(FollowBean.FollowListBean followListBean) {
//                followAdapter.mList.remove(followListBean);
//                followAdapter.notifyDataSetChanged();
//            }
//        });
        mFullDelDemoAdapter.setOnDelListener(new FullDelDemoAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                if (pos >= 0 && pos < followList.size()) {

                    followList.remove(pos);
                    mFullDelDemoAdapter.notifyItemRemoved(pos);//推荐用这个
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((SwipeMenuLayout) holder.itemView).quickClose();
                    //mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTop(int pos) {

            }
        });
    }

    @Override
    protected FollowPresenter<FollowMvp.FollowView> createPresenter() {
        return new FollowPresenter<>();
    }


}
